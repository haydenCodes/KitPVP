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

public class Forager extends Kit {

	@Override
	public void giveTo(Player p) {
	
		ItemBuilder sword = new ItemBuilder(Material.DIAMOND_SPADE).addEnchant(Enchantment.DAMAGE_ALL, 3);
		ItemBuilder rod = new ItemBuilder(Material.FISHING_ROD).addEnchant(Enchantment.DURABILITY, 3);
		ItemBuilder helmet = new ItemBuilder(Material.LEATHER_HELMET);
		ItemBuilder chest = new ItemBuilder(Material.DIAMOND_CHESTPLATE).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		ItemBuilder legs = new ItemBuilder(Material.LEATHER_LEGGINGS);
		ItemBuilder boots = new ItemBuilder(Material.DIAMOND_BOOTS);
		ItemBuilder bow = new ItemBuilder(Material.BOW);
		
		p.getInventory().addItem(sword.build(), rod.build(), bow.build(), new ItemStack(Material.ARROW, 5));
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
		
		return new ItemBuilder(Material.DIAMOND_AXE).withName(ChatColor.GREEN + "Forager").build();
		
	}
	
	@Override
	public ClassType getGroup() {
		
		return ClassType.OUTLANDER;
		
	}
	
	@Override
	public String getName() {
		
		return "forager";
		
	}

	@Override
	public KitType getKitType() {
		// TODO Auto-generated method stub
		return KitType.FORAGER;
	}
	
}
