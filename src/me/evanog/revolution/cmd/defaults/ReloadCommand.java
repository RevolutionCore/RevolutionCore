package me.evanog.revolution.cmd.defaults;

import org.bukkit.command.CommandSender;

import me.evanog.revolution.cmd.SimpleCommand;

public class ReloadCommand extends SimpleCommand {

	public ReloadCommand() {
		super("reloadrevolution");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onExecute(CommandSender p) {
		this.getConfigFactory().reloadConfig();
		p.sendMessage("Config reloaded successfully!");
	}

}
