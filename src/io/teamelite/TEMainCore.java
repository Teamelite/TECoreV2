package io.teamelite;

import io.teamelite.plugins.test.Test;

import org.bukkit.plugin.java.JavaPlugin;
import org.omg.CORBA.DynAnyPackage.InvalidValue;

public class TEMainCore extends JavaPlugin{
	
	public CorePlugin[] Plugins = new CorePlugin[]{new Test()};
	
	@Override
	public void onEnable() {
		for(CorePlugin p : Plugins){
			try {
				p.init(this);
			} catch (InvalidValue e) {
				e.printStackTrace();
				break;
			}
		}
	}
	
	@Override
	public void onDisable() {
		for(CorePlugin p : Plugins){
			p.onDisable();
		}
	}

}
