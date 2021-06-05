package com.briangershon.motd_3t3n;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import java.io.File;

public class App extends JavaPlugin implements Listener {

    @Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
	}

    @EventHandler
	public void onPing(ServerListPingEvent e) {
		// e.setMaxPlayers(16);
		e.setMotd(ChatColor.GREEN.toString() + ChatColor.BOLD.toString() + "New stuff coming to Turtletown!" + "\n" + ChatColor.RESET.toString() + ChatColor.DARK_PURPLE.toString() + ChatColor.ITALIC.toString() + ChatColor.UNDERLINE.toString() + "More ranks coming to the server soon!");

		try {
			e.setServerIcon(Bukkit.loadServerIcon(new File("3t3n-icon.png")));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}