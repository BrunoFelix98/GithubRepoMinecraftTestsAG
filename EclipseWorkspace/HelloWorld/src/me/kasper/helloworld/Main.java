package me.kasper.helloworld;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	@Override
	public void onEnable() {
		
		//this.getCommand("hello").setExecutor(new Main());
		//Startup
		//Reloads
		//Plugin reloads
	}
	
	@Override
	public void onDisable() {
		//Shutdown
		//Reloads
		//Plugin reloads
	}
	
	//Hello
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(label.equalsIgnoreCase("hello"))
		{
			if(sender instanceof Player)
			{
				//Player
				Player plyr = (Player) sender;
				if(plyr.hasPermission("hello.use"))
				{
					plyr.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Hey welcome to the server!");
					plyr.sendMessage(ChatColor.translateAlternateColorCodes('&', "&1H&2a&3v&4e &5f&6u&7n&8!"));
					return true;
				}
				else
				{
					plyr.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Insufficient permission");
					return true;
				}
			}
			else
			{
				//Console
				sender.sendMessage("Hey console!");
				return true;
			}
		}
		
		return false;
	}
}
