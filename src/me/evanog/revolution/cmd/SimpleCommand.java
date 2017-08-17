package me.evanog.revolution.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.evanog.revolution.Core;
import me.evanog.revolution.utils.ConfigFactory;

public abstract class SimpleCommand implements CommandExecutor {

	private String command;
	
	public SimpleCommand(String command) {
		this.command = command;
	}
	
	public boolean check(CommandSender sender) {
		if (sender instanceof Player) {
			if (sender.hasPermission(this.permission())) {
				return true;
			}else {
				sender.sendMessage(this.getConfigFactory().noPermission);
			}
		}
		return false;
	}
	
	public abstract void onExecute(CommandSender p);
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String adad, String[] args) {
		if (check(sender)) {
			Player p = (Player) sender;
			this.onExecute(p);
		}
		return false;
	}

	public void setupCommand() {
		Core.getInstance().getCommand(command).setExecutor(this);	
	}
	
	protected String permission() {
		return "Revolution.Command" + command;
	}
	
	public ConfigFactory getConfigFactory() {
		return Core.getInstance().getConfigFactory();
	}
	
	
}
