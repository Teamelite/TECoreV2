package io.teamelite;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.omg.CORBA.DynAnyPackage.InvalidValue;

public abstract class CorePlugin{
	
	private static TEMainCore core;
	
	private String name;
	
	protected final String prefix = "[TECore]";
	
	public void init(TEMainCore corearg) throws InvalidValue{
		core = corearg;
		name = getPluginName();
		if(name==null){
			throw new InvalidValue("name can not be null");
		}
		for(CorePlugin p : core.Plugins){
			if(!p.equals(this)){
				if(p.getPluginName().equals(name)){
					throw new InvalidValue("Duplicate name: "+name);
				}
			}
		}
		registerEvents();
		registerCommands();
		onEnable();
	};
	
	public abstract void onEnable();
	
	public abstract void onDisable();
	
	public abstract String getPluginName();
	
	public abstract void registerCommands();
	
	public abstract void registerEvents();
	
	protected Player getPlayer(String playerName){
		Object[] playerlist = Bukkit.getServer().getOnlinePlayers().toArray();
		
		for(Object Playerobject : playerlist){
			Player temp = (Player) Playerobject;
			if(temp.getDisplayName().equalsIgnoreCase(playerName)){
				return temp;
			}
		}
		return null;
	}
	
	@SuppressWarnings("unused")
	private String prefix(){
		return prefix;
	}
	
	public void registerCommand(String commandName, CommandExecutor executor){
		core.getCommand(commandName).setExecutor(executor);
	}
	
	public void registerEvent(Listener listener){
		Bukkit.getServer().getPluginManager().registerEvents(listener, core);
	}
	
}
