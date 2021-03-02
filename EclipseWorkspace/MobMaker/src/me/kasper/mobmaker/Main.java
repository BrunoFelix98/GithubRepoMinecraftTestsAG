package me.kasper.mobmaker;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.kasper.mobmaker.events.BlockPlace;
import me.kasper.mobmaker.events.EntityDamage;
import me.kasper.mobmaker.events.EntityDeath;
import me.kasper.mobmaker.events.SnekDamage;
import me.kasper.mobmaker.events.SpawnMob;

public class Main extends JavaPlugin {

	public List<ItemStack> stolenItems = new ArrayList<>();
	
	@Override
	public void onEnable() {
		
		//this.getCommand("hello").setExecutor(new Main());
		//Startup
		//Reloads
		//Plugin reloads
		
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new EntityDamage(), this);
		pm.registerEvents(new EntityDeath(this), this);
		pm.registerEvents(new BlockPlace(this), this);
		pm.registerEvents(new SnekDamage(), this);
		
		this.getCommand("spawnskelly").setExecutor(new SpawnMob());
		this.getCommand("spawnsnek").setExecutor(new SpawnMob());
	}
	
	@Override
	public void onDisable() {
		//Shutdown
		//Reloads
		//Plugin reloads
	}
}
