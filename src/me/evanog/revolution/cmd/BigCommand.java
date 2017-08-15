package me.evanog.revolution.cmd;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.evanog.revolution.Core;
import me.evanog.revolution.utils.ChatUtils;

public abstract class BigCommand implements CommandExecutor {

	private String name;
	private String permission;
	private String usage;
	private boolean playerOnly;
	private CommandArgument helpArgument;

	public BigCommand(String name, String permission, String usage, boolean playerOnly, CommandArgument helpArgument) {
		this.name = name;
		this.permission = permission;
		this.usage = usage;
		this.playerOnly = playerOnly;
		this.helpArgument = helpArgument;
	}
	

	public abstract List<CommandArgument> getArguments();

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (this.playerOnly && !(sender instanceof Player)) {
			sender.sendMessage(ChatUtils.format(Core.prefix + "&cOnly Players can run this command!"));
			return false;
		}
		if (args.length == 0) {
			//Do later
			return true;
		}
		String first = args[0];
	
		return false;
	}

	public void register() {

	}

}
