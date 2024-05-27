package shop;

import java.util.ArrayList;
import org.bukkit.inventory.ItemStack;

public class Shop {
	static ArrayList<ItemStack> BuildingBlocks = new ArrayList<ItemStack>();
	public static void addPageItem(ItemStack stack, String page) {
		if (page == "BuildingBlocks") {
			BuildingBlocks.add(stack);
		}
	}
}
