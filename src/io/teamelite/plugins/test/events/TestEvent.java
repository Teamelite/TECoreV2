package io.teamelite.plugins.test.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class TestEvent implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		System.out.println(e.getPlayer().getName());
	}

}
