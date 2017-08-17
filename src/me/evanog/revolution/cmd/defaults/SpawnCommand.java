package me.evanog.revolution.cmd.defaults;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.evanog.revolution.cmd.SimpleCommand;

public class SpawnCommand extends SimpleCommand {

	public SpawnCommand() {
		super("spawn");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean check(CommandSender sender) {
		if (sender instanceof Player) {
			return true;
		}
		return false;
	}

	@Override
	public void onExecute(CommandSender sender) {
		Player p = (Player) sender;
		if (p.hasPermission(this.permission())) {
			p.teleport(new Location(Bukkit.getWorld("world"),98,0, 0));
		} else {
			p.sendMessage(this.getConfigFactory().spawn);
		}
	}

}
