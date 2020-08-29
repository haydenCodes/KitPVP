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

public class Assassin extends Kit {

	@Override
	public void giveTo(Player p) {
	
		ItemBuilder sword = new ItemBuilder(Material.DIAMOND_SWORD).addEnchant(Enchantment.DAMAGE_ALL, 1);
		ItemBuilder rod = new ItemBuilder(Material.FISHING_ROD).addEnchant(Enchantment.DURABILITY, 3);
		ItemBuilder helmet = new ItemBuilder(Material.LEATHER_HELMET).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		ItemBuilder chest = new ItemBuilder(Material.LEATHER_CHESTPLATE).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		ItemBuilder legs = new ItemBuilder(Material.LEATHER_LEGGINGS).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		ItemBuilder boots = new ItemBuilder(Material.LEATHER_BOOTS).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		
		p.getInventory().addItem(sword.build(), rod.build());
		p.getInventory().setHelmet(helmet.build());
		p.getInventory().setChestplate(chest.build());
		p.getInventory().setLeggings(legs.build());
		p.getInventory().setBoots(boots.build());		
		
	}

	@Override
	public Kit getKit() {
		
		return this;

	}

	@Override
	public ItemStack getIcon() {		
		
		return new ItemBuilder(Material.DIAMOND_AXE).withName(ChatColor.GREEN + "Assasin").build();
		
	}
	
	@Override
	public ClassType getGroup() {
		
		return ClassType.MELEE;
		
	}
	
	@Override
	public String getName() {
		
		return "assassin";
		
	}

	@Override
	public KitType getKitType() {
		// TODO Auto-generated method stub
		return KitType.ASSASSIN;
	}
	
}
