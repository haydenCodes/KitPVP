package me.icky.util;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {
		
	private final ItemStack item;
	
	public ItemBuilder(Material mat) {
		
		this.item = new ItemStack(mat);
		
	}
	
	public ItemBuilder withName(String name) {
		
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		this.item.setItemMeta(meta);
		
		return this;
		
	}
	
	public ItemBuilder addEnchant(Enchantment enchant, int level) {
		
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(enchant, level, true);
		this.item.setItemMeta(meta);
		
		return this;
		
	}
	
	public ItemStack build() {
		
		return this.item;
		
	}
	
}