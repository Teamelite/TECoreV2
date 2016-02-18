package io.teamelite.plugins.test.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TestCMD implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if(cmd.getName().equalsIgnoreCase("test")){
			System.out.println("alive");
			return true;
		}
		return false;
	}

}
