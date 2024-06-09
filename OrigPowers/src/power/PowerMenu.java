package power;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.Inventory;

public class PowerMenu {
	public static void servePowerMenu(PlayerEvent e) {
		Player player = e.getPlayer();
		Inventory inv = Bukkit.getServer().createInventory(player, 54, "Power menu");
		
		for (int i = 0; i > 9; i++) {
			
		}
	}
}
