package me.kasper.mobmaker.events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SnekDamage implements Listener{

	public boolean venomous;
	public boolean extVenomous;
	
	@EventHandler
	public void onAttack(EntityDamageByEntityEvent event) {
				
	    Entity entity = event.getEntity();
	    Entity damager = event.getDamager();
	    
	    LivingEntity target = (LivingEntity) entity;
		target.sendMessage("I got to onAttack!" + " " + venomous + " " + extVenomous);
	    
	    if(venomous)
	    {
	    	int seconds = 10;
		    
		    int amplifier = 1;
		    
	    	if (entity instanceof LivingEntity && damager instanceof LivingEntity) {
		         LivingEntity target1 = (LivingEntity) entity;
		         target1.addPotionEffect(new PotionEffect(PotionEffectType.POISON, seconds * 20 * 3, amplifier));
		     }
	    }
	    
	    if(extVenomous)
	    {
	    	int seconds = 10;
		    
		    int amplifier = 2;
		    
	    	if (entity instanceof LivingEntity && damager instanceof LivingEntity) {
		         LivingEntity target1 = (LivingEntity) entity;
		         target1.addPotionEffect(new PotionEffect(PotionEffectType.POISON, seconds * 20 * 3, amplifier));
		     }
	    }
	}
}