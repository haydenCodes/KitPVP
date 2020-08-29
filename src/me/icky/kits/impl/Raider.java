package me.icky.kits.impl;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import gg.glade.core.game.kit.KitType;
import me.icky.kits.ClassType;
import me.icky.kits.Kit;
import me.icky.util.ItemBuilder;
import net.md_5.bungee.api.ChatColor;

public class Raider extends Kit {

	@Override
	public void giveTo(Player p) {
	
		ItemBuilder sword = new ItemBuilder(Material.WOOD_SWORD).addEnchant(Enchantment.DAMAGE_ALL, 3);
		ItemBuilder rod = new ItemBuilder(Material.FISHING_ROD).addEnchant(Enchantment.DURABILITY, 3);
		ItemBuilder chest = new ItemBuilder(Material.LEATHER_CHESTPLATE).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		
		p.getInventory().addItem(sword.build(), rod.build());
		p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
		p.getInventory().setChestplate(chest.build());
		p.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
		p.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));		
		
	}

	@Override
	public Kit getKit() {
		
		return this;

	}

	@Override
	public ItemStack getIcon() {		
		
		return new ItemBuilder(Material.DIAMOND_AXE).withName(ChatColor.GREEN + "Raider").build();
		
	}
	
	@Override
	public ClassType getGroup() {
		
		return ClassType.MELEE;
		
	}
	
	@Override
	public String getName() {
		
		return "raider";
		
	}

	@Override
	public KitType getKitType() {
		// TODO Auto-generated method stub
		return KitType.RAIDER;
	}
	
}
