package me.evanog.revolution.cmd;

import org.bukkit.command.CommandSender;

public abstract class CommandArgument {

	public abstract void execute(CommandSender sender,String[] args);
	
}
