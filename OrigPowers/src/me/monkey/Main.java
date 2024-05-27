package me.monkey;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
//import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;


import power.Power;
import power.PowerMethods;
import power.PowerMethodsInterface;

public class Main extends JavaPlugin implements Listener{
	//static FileConfiguration config = Main.getPlugin(Main.class).getConfig();
	static HashMap<String, Power> playerPower = new HashMap<String, Power>();
	static HashMap<String, Double> playerPowerCooldown = new HashMap<String, Double>();
	static BukkitTask gameloop;
    @Override
    public void onEnable() {
    	Bukkit.broadcastMessage("Plugin on");
    	Bukkit.getPluginManager().registerEvents(this,this);
    	gameloop = Bukkit.getServer().getScheduler().runTaskTimerAsynchronously(Main.this, new Runnable(){
			public void run() {
				for (Player p : Bukkit.getServer().getOnlinePlayers()) {
					if (playerPowerCooldown.get(p.getName()) != null) {
						if (playerPowerCooldown.get(p.getName() ) > 0)  {
							Double rounded1 = playerPowerCooldown.get(p.getName())*10;
							Double rounded2 = (double) (Math.round(rounded1)/10);
							playerPowerCooldown.put(p.getName(), rounded2-0.1);
							if (playerPowerCooldown.get(p.getName()) <= 0.0) {
                                playerPowerCooldown.put(p.getName(), 0.0);
                            }
							p.sendMessage(ChatColor.LIGHT_PURPLE + " Cooldown: "+ ChatColor.DARK_PURPLE + playerPowerCooldown.get(p.getName()));
						}
					}
				}
			}
    	},20, 2);
    } 
    @Override
    public void onDisable() {
    	Bukkit.broadcastMessage("Plugin off");
    }
    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent e) {
    	PowerMethods pm = new PowerMethods();
    	String playerName = e.getPlayer().getName();
    	if (playerPower.get(playerName) == null || playerPowerCooldown.get(playerName) == null) {
    		playerPower.put(playerName, new Power(pm.new Power_Phantom(), 15));
    		playerPowerCooldown.put(playerName, 0.0);
    	} else {
    		System.out.println(playerPower.get(playerName));
    	}
    	
    }
    @EventHandler
    public static void onPlayerChat(AsyncPlayerChatEvent event) {
    	Player player = event.getPlayer();
    	String message = event.getMessage();
    	if (message.contains("gaia")) {
    		PowerMethods pm = new PowerMethods();
    		playerPower.put(player.getName(), new Power(pm.new Power_Gaia(), 5));
    		player.sendMessage(ChatColor.LIGHT_PURPLE + "Power Changed!");
    	}
    }
    @EventHandler
    public static void onSwapHands(PlayerSwapHandItemsEvent event) {
    	event.setCancelled(true);
    	Player player = event.getPlayer();
    	String playerName = player.getName();
    	Double powerCooldown = playerPowerCooldown.get(playerName);
    	if (powerCooldown <= 0.0) {    	
    		Power power = playerPower.get(playerName);
    		PowerMethodsInterface powerFunctions = power.getPowerObject();
    		powerFunctions.onSwapHands(event);
    		playerPowerCooldown.put(playerName, (double) power.getCooldown());
    	}
    }
    @EventHandler
    public static void onSneak(PlayerToggleSneakEvent event) {
    	Player player = event.getPlayer();
    	Power power = playerPower.get(player.getName());
    	PowerMethodsInterface powerFunctions = power.getPowerObject();
    	powerFunctions.onSneak(event);
    }
    
    @EventHandler
    public static void onInteractWithEntity(PlayerInteractEntityEvent event) {
    	Player player = event.getPlayer();
    	Power power = playerPower.get(player.getName());
    	PowerMethodsInterface powerFunctions = power.getPowerObject();
    	powerFunctions.onInteractWithEntity(event, event.getRightClicked());
    }
}   		 
    