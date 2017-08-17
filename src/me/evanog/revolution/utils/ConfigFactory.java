package me.evanog.revolution.utils;

import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;

import me.evanog.revolution.Core;

public class ConfigFactory {

	private final FileConfiguration config = Core.getInstance().getConfig();

	public final String noPermission, cobbleDisabled, cobbleEnabled, spawn;

	public final List<String> mapkitMessage;

	public ConfigFactory() {
		config.addDefault("MapKit_Message", new String[] { "&e&lSharpness 2 Protection 2" });
		config.addDefault("No_Permission", "&cYou do not have permission!");
		config.addDefault("Cobble_Enabled", "&cYou have disabled picking up of cobblestone!");
		config.addDefault("Cobble_Disabled", "&aYou have re-enabled the picking up of cobblestone!");
		config.addDefault("Spawn_Walk", "&cThis command does not exist.  You must walk to spawn located at 0,0.");
		config.options().copyDefaults(true);
		Core.getInstance().saveConfig();
		this.mapkitMessage = ChatUtils.formatList(config.getStringList("MapKit_Message"));
		this.noPermission = ChatUtils.format(config.getString("No_Permission"));
		this.cobbleDisabled = ChatUtils.format(config.getString("Cobble_Disabled"));
		this.cobbleEnabled = ChatUtils.format(config.getString("Cobble_Enabled"));
		this.spawn = ChatUtils.format(config.getString("Spawn_Walk"));
	}

	public void reloadConfig() {
		Core.getInstance().reloadConfig();
	}

}
