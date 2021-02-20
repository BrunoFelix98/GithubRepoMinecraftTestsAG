package me.kasper.mobmaker.events;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import me.kasper.mobmaker.Main;

public class EntityDeath implements Listener{

	private Main plugin;
	public EntityDeath(Main plugin) {
		this.plugin = plugin;
	}
	
	private ItemStack[] theifDInventory = {
			new ItemStack(Material.GOLD_INGOT, 16),
			new ItemStack(Material.DIAMOND_BLOCK, 2),
			new ItemStack(Material.NETHERITE_SWORD, 1),
	};
	
	@EventHandler
	public void onDeath(EntityDeathEvent event) {
		
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
		
		event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(), theifDInventory[r.nextInt(theifDInventory.length + 0) - 0]);
	
		for(ItemStack item : plugin.stolenItems)
		{
			if(item != null)
			{
				event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(), item);
			}
		}
	}
}