package power;

import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public interface PowerMethodsInterface {
	public void onSneak(PlayerToggleSneakEvent e);
	public void onSwapHands(PlayerSwapHandItemsEvent e);
	public void onDamage(EntityDamageByEntityEvent e);
	public void onInteractWithEntity(PlayerInteractEntityEvent e, Entity w);
}
