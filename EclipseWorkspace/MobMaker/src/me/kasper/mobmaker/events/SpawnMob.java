package me.kasper.mobmaker.events;

import org.bukkit.attribute.Attribute;
//import org.bukkit.attribute.Attributable;
//import org.bukkit.attribute.Attribute;
//import org.bukkit.attribute.AttributeInstance;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.entity.Player;

import me.kasper.mobmaker.mobs.SSkeleton;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_16_R3.WorldServer;

public class SpawnMob implements CommandExecutor {
	
	//SSkeleton skelly;
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	
		if(label.equalsIgnoreCase("spawnskelly"))
		{
			if(!(sender instanceof Player))
			{
				return true;
			}
			
			Player player = (Player) sender;
			
			WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
			
			/*Attributable skellyAttributable = (Attributable) skelly;
			AttributeInstance ai = skellyAttributable.getAttribute(Attribute.GENERIC_MAX_HEALTH);
			ai.getDefaultValue();*/
			
			SSkeleton skelly = new SSkeleton(player.getLocation());
			world.addEntity(skelly);
			skelly.setHealth(20000.0f);
			skelly.setHealth((float) player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue());
			player.sendMessage(ChatColor.RED + "Big skelly spawned!");
			return true;
		}
		return false;
	}
}
