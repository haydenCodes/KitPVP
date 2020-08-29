package me.icky.kits;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import gg.glade.core.game.kit.KitType;

public abstract class Kit {
	
	public abstract void giveTo(Player p);
	public abstract Kit getKit();
	public abstract ItemStack getIcon();
	public abstract ClassType getGroup();
	public abstract KitType getKitType();
	public abstract String getName();
	
}
