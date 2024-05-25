package me.monkey;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.plugin.java.JavaPlugin;

import power.Power;
import power.PowerMethods;
import power.PowerMethodsInterface;

public class Main extends JavaPlugin implements Listener{
	static FileConfiguration config = Main.getPlugin(Main.class).getConfig();
	static HashMap<String, Power> playerPower = new HashMap<String, Power>();
    @Override
    public void onEnable() {
    	Bukkit.broadcastMessage("Plugin on");
    	Bukkit.getPluginManager().registerEvents(this,this);
    } 
    @Override
    public void onDisable() {
    	Bukkit.broadcastMessage("Plugin off");
    }
    @EventHandler
    public static void playerJoin(PlayerJoinEvent e) {
    	PowerMethods pm = new PowerMethods();
    	String playerName = e.getPlayer().getName();
    	if (playerPower.get(playerName).equals(null)) {
    		playerPower.put(playerName, new Power(pm.new Power_Phantom()));
    	} else {
    		System.out.println(playerPower.get(playerName));
    	}
    	
    }
    @EventHandler
    public static void swapHands(PlayerSwapHandItemsEvent event) {
    	event.setCancelled(true);
    	PowerMethods pm = new PowerMethods();
    	Power p = new Power(pm.new Power_Phantom());
    	
    }
}   		 
    
