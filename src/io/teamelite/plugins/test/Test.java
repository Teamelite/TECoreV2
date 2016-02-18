package io.teamelite.plugins.test;

import io.teamelite.CorePlugin;
import io.teamelite.plugins.test.commands.TestCMD;
import io.teamelite.plugins.test.events.TestEvent;

public class Test extends CorePlugin{

	@Override
	public String getPluginName() {
		return "Test";
	}

	@Override
	public void registerCommands() {
		registerCommand("test", new TestCMD());
	}

	@Override
	public void registerEvents() {
		registerEvent(new TestEvent());
	}

	@Override
	public void onEnable() {
		
	}

	@Override
	public void onDisable() {
		
	}
	

}
