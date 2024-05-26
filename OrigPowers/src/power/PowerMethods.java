package power;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PowerMethods {
	public class Power_Phantom implements PowerMethodsInterface {
		public void onSneak(PlayerToggleSneakEvent e) {
			if (e.isSneaking()) {
				PotionEffect invisible = new PotionEffect(PotionEffectType.INVISIBILITY,Integer.MAX_VALUE,1,false,false,false);
				e.getPlayer().addPotionEffect(invisible);
			} else {
				e.getPlayer().removePotionEffect(PotionEffectType.INVISIBILITY);
			}
		}

		@Override
		public void onSwapHands(PlayerSwapHandItemsEvent e) {
			Player player = e.getPlayer();
			PotionEffect invisible = new PotionEffect(PotionEffectType.INVISIBILITY,15,1,false,false,false);
			player.addPotionEffect(invisible);
			player.setVelocity(player.getLocation().getDirection().multiply(0.7D));
		}

		@Override
		public void onDamage(EntityDamageByEntityEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	public class Power_Berserk implements PowerMethodsInterface {
		 
		@Override
		public void onSneak(PlayerToggleSneakEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSwapHands(PlayerSwapHandItemsEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onDamage(EntityDamageByEntityEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
