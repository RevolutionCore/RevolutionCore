package me.evanog.revolution.cmd.defaults;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

import me.evanog.revolution.cmd.SimpleCommand;

public class CobbleCommand extends SimpleCommand implements Listener {

	public CobbleCommand() {
		super("cobble");
		// TODO Auto-generated constructor stub
	}

	private static Set<Player> cobble = new HashSet<>();

	@Override
	public void onExecute(CommandSender sender) {
		Player p = (Player) sender;
		if (cobble.contains(p)) {
			cobble.remove(p);
			p.sendMessage(this.getConfigFactory().cobbleDisabled);
		} else {
			cobble.add(p);
			p.sendMessage(this.getConfigFactory().cobbleEnabled);
		}

	}

	@EventHandler
	public void onItemPickup(PlayerPickupItemEvent e) {
		if (e.getItem().getItemStack().getType() == Material.COBBLESTONE && cobble.contains(e.getPlayer())) {
			e.setCancelled(true);
		}
	}

}
