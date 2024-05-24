package me.monkey;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.player.PlayerMoveEvent;
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
    public static void playerMove(PlayerMoveEvent event) {
    }
}   		 
    
