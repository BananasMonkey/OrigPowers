package power;

import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public interface PowerMethodsInterface {
	public void onSneak(PlayerToggleSneakEvent e);
	public void onSwapHands(PlayerSwapHandItemsEvent e);
}
