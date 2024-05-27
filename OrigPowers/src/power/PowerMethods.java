package power;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class PowerMethods {
	public class Power_Phantom implements PowerMethodsInterface {
		@Override
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

		@Override
		public void onInteractWithEntity(PlayerInteractEntityEvent e, Entity w) {
			// TODO Auto-generated method stub
			
		}

	}
	public class Power_Gaia implements PowerMethodsInterface {
		@Override
		public void onSneak(PlayerToggleSneakEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSwapHands(PlayerSwapHandItemsEvent e) {
			Player player = e.getPlayer();
			Block block = player.getTargetBlockExact(5);
			if (block != null) {
				Location blockLocation = block.getLocation();
				World world = block.getWorld();
				Location locationShift = new Location(world,0.5,0,0.5);
				Location newLocation = blockLocation.add(locationShift);
				BlockData blockData = block.getBlockData();
				FallingBlock fallingBlock = world.spawnFallingBlock(newLocation, blockData);
				fallingBlock.setDropItem(false);
				Vector v = new Vector(0,0.7,0);
				fallingBlock.setVelocity(v);
				block.setType(Material.AIR);
			}
			
		}

		@Override
		public void onDamage(EntityDamageByEntityEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void onInteractWithEntity(PlayerInteractEntityEvent e, Entity w) {
			if (w.getType() == EntityType.FALLING_BLOCK) {
				Player player = e.getPlayer();
				w.setVelocity(player.getLocation().getDirection().multiply(0.95D));
			}
			
		}
		
	}
}
