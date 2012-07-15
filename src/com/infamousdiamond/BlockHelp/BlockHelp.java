package com.infamousdiamond.BlockHelp;

import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class BlockHelp extends JavaPlugin
{
	
	public final Logger log = Logger.getLogger("Minecraft");
	public static BlockHelp plugin;
	
	
	
	public void onDisable()
	{
		
		//Happens when the server is turned off/ crashes; Gets the plugin.yml file and tells the console that it's now disabled.
		PluginDescriptionFile pdfFile = this.getDescription();
		this.log.info(pdfFile.getName() + " Has Been Disabled.");
		
	}
	
	public void onEnable()
	{
		
		//Happens when the server starts up; Gets the plugin.yml file and alerts the console that it's now enabled.
		PluginDescriptionFile pdfFile = this.getDescription();
		this.log.info(pdfFile.getName() + " Has Been Enabled." + pdfFile.getVersion());
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		
		if(sender instanceof Player)
		{
			
			Player player = (Player) sender;
			
			
			
			if(commandLabel.equalsIgnoreCase("BHelp") || commandLabel.equalsIgnoreCase("BlockHelp"))
			{
				ItemStack InHand = player.getItemInHand();
				int BlockID = InHand.getType().getId();
				String BlockName = Material.getMaterial(BlockID).name().toLowerCase().replace("_", " ");
				
				player.sendMessage("Block Name: " + BlockName);
				player.sendMessage("Data Value: " + BlockID);
			}
			
		}
		
		return false;
	}

}
