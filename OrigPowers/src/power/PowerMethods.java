package power;

import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PowerMethods {
	public class Power_Phantom implements PowerMethodsInterface {
		public void onSneak(PlayerToggleSneakEvent e) {
			if (e.isSneaking()) {
				PotionEffect invisible = new PotionEffect(PotionEffectType.INVISIBILITY,15,1,false,false,false);
				e.getPlayer().addPotionEffect(invisible);
			}
		}
	}
}
