package me.kasper.mobmaker.events;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class EntityDamage implements Listener{
	
	private ItemStack[] theifInventory = {
			new ItemStack(Material.GOLD_NUGGET, 16),
			new ItemStack(Material.GOLD_BLOCK, 2),
			new ItemStack(Material.NETHERITE_CHESTPLATE, 1),
	};
	
	@EventHandler
	public void onDamage(EntityDamageEvent event) {
		
		if(!(event.getEntity() instanceof Villager))
		{
			return;
		}
		if((event.getEntity().getCustomName() == null))
		{
			return;
		}
		if(!event.getEntity().getCustomName().contains("Big boi"))
		{
			return;
		}
		
		Random r = new Random();
		
		event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(), theifInventory[r.nextInt(theifInventory.length + 0) - 0]);
	}
}
