package me.monkey;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{

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
    	
    }
    @EventHandler
    public static void swapHands(PlayerSwapHandItemsEvent event) {
    	event.setCancelled(true);
    	PowerMethods pm = new PowerMethods();
    	FileConfiguration config = Main.getPlugin(Main.class).getConfig();
    	//playerPower = 
    	Power p = new Power(pm.new Power_Phantom());
    	
    }
}   		 
    
