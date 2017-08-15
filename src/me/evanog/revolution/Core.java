package me.evanog.revolution;

import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.collect.ImmutableList;

import me.evanog.revolution.utils.ChatUtils;

public final class Core extends JavaPlugin {

	private static Core instance;
	private final ImmutableList<Manager> managers = ImmutableList.of();
	public static final String prefix = ChatUtils.format("&7[&eRevolution&7] ");
	
	public static Core getInstance() {
		return instance;

	}
	
	@Override
	public void onEnable() {
		instance = this;
	}
	
	@Override
	public void onDisable() {
		instance = null;
	}
	
	private void registerListeners() {
		
	}
	
	private void registerCommands() {
		
	}
	
	private void enableManagers() {
		for (Manager manager : this.managers) {
			manager.enable();
		}
	}
	
	private void disableManagers() {
		for (Manager manager : this.managers) {
			manager.disable();
		}	
	}
}
