package me.kasper.mobmaker.events;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.entity.Player;

import me.kasper.mobmaker.mobs.SSkeleton;
import me.kasper.mobmaker.mobs.Snakes;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_16_R3.WorldServer;

public class SpawnMob implements CommandExecutor {
	
	String[] args;
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	
		this.args = args;
		
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
			skelly.setAbsorptionHearts(20000);
			world.addEntity(skelly);
			player.sendMessage(ChatColor.RED + "Big skelly spawned!");
			player.sendMessage(ChatColor.YELLOW + "" + skelly.getAbsorptionHearts());
			return true;
		}
		if(label.equalsIgnoreCase("spawnsnek"))
		{
			if(!(sender instanceof Player))
			{
				return true;
			}
			
			Player player = (Player) sender;
			
			WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
			
			Snakes snek = new Snakes(player.getLocation());
			
			if(args[0].equalsIgnoreCase("true"))
			{
				if (args.length >= 1)
				{
					snek.venomous = true;
				}
			}
			else
			{
				if (args.length >= 1)
				{
					snek.venomous = false;
				}
			}
			if(args[1].equalsIgnoreCase("true"))
			{
				if (args.length >= 1)
				{
					snek.extVenomous = true;
				}
			}
			else
			{
				if (args.length >= 1)
				{
					snek.extVenomous = false;
				}
			}
			
			world.addEntity(snek);
			player.sendMessage(ChatColor.RED + "Snek spawned!");
			player.sendMessage(this.args[0] + " " + this.args[1]);
			return true;
		}
		
		return false;
	}
}
