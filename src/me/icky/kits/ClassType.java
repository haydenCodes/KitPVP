package me.icky.kits;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import me.icky.util.ItemBuilder;

public enum ClassType {
	
	MELEE(new ItemBuilder(Material.FISHING_ROD).withName(ChatColor.AQUA + "Melee").build()), 
	RANGED(new ItemBuilder(Material.FISHING_ROD).withName(ChatColor.AQUA + "Ranged").build()), 
	OUTLANDER(new ItemBuilder(Material.FISHING_ROD).withName(ChatColor.AQUA + "Outlander").build());
	
	private ItemStack icon;
	
	ClassType(ItemStack type) {
		
		this.icon = type;
		
	}
	
	public ItemStack getIcon() {
		
		return this.icon;
		
	}
	
}
