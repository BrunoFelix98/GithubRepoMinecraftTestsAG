package me.kasper.mobmaker.mobs;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;

import me.kasper.mobmaker.events.SnekDamage;
import net.minecraft.server.v1_16_R3.ChatComponentText;
import net.minecraft.server.v1_16_R3.EntityTypes;
import net.minecraft.server.v1_16_R3.EntityZombie;

public class Snakes extends EntityZombie{
	
	public boolean venomous;
	public boolean extVenomous;
	
	SnekDamage snekDmg = new SnekDamage();
	
	public Snakes(Location loc) {
		
		super(EntityTypes.ZOMBIE, ((CraftWorld) loc.getWorld()).getHandle());
		
		this.setPosition(loc.getX(), loc.getY(), loc.getZ());
		
		this.setCustomName(new ChatComponentText("Snek"));
		
		this.setCustomNameVisible(true);
		this.setAggressive(true);
		snekDmg.venomous = this.venomous;
		snekDmg.extVenomous = this.extVenomous;
	}
}