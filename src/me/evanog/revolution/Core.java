package me.evanog.revolution;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.collect.ImmutableList;

import me.evanog.revolution.cmd.defaults.CobbleCommand;
import me.evanog.revolution.cmd.defaults.MapKitCommand;
import me.evanog.revolution.cmd.defaults.ReloadCommand;
import me.evanog.revolution.cmd.defaults.SpawnCommand;
import me.evanog.revolution.utils.ChatUtils;
import me.evanog.revolution.utils.ConfigFactory;

public final class Core extends JavaPlugin {

	private static Core instance;
	private final ImmutableList<Manager> managers = ImmutableList.of();
	public static final String prefix = ChatUtils.format("&7[&eRevolution&7] ");
	private ConfigFactory cFactory;
	
	
	public static Core getInstance() {
		return instance;
	}
	
	@Override
	public void onEnable() {
		instance = this;
		this.cFactory = new ConfigFactory();
		this.enableManagers();
		this.disableManagers();
		this.registerCommands();
		this.registerListeners();
	}
	
	@Override
	public void onDisable() {
		instance = null;
	}
	
	private void registerListeners() {
		Bukkit.getPluginManager().registerEvents(new CobbleCommand(), this);
	}
	
	private void registerCommands() {
		new MapKitCommand().setupCommand();
		new ReloadCommand().setupCommand();
		new CobbleCommand().setupCommand();
		new SpawnCommand().setupCommand();
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
	
	public ConfigFactory getConfigFactory() {
		return this.cFactory;
	}
}
