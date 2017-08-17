package me.evanog.revolution.cmd.defaults;

import org.bukkit.command.CommandSender;

import me.evanog.revolution.Core;
import me.evanog.revolution.cmd.SimpleCommand;

public class MapKitCommand extends SimpleCommand {

	public MapKitCommand() {
		super("mapkit");
	}

	@Override
	public void onExecute(CommandSender p) {
		System.out.print( this.getConfigFactory().mapkitMessage);
		for (String s : this.getConfigFactory().mapkitMessage) {
			p.sendMessage(s);
		}
	}

	
	
}
