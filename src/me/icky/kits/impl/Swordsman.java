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

public class Swordsman extends Kit {

	@Override
	public void giveTo(Player p) {
	
		ItemBuilder sword = new ItemBuilder(Material.STONE_SWORD).addEnchant(Enchantment.DAMAGE_ALL, 1);
		ItemBuilder rod = new ItemBuilder(Material.FISHING_ROD).addEnchant(Enchantment.DURABILITY, 3);
		
		p.getInventory().addItem(sword.build(), rod.build(), new ItemStack(Material.BOW), new ItemStack(Material.ARROW, 8));
		p.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
		p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
		p.getInventory().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
		p.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));		
		
	}

	@Override
	public Kit getKit() {
		
		return this;

	}

	@Override
	public ItemStack getIcon() {		
		
		return new ItemBuilder(Material.STONE_SWORD).withName(ChatColor.GREEN + "Swordsman").build();
		
	}
	
	@Override
	public ClassType getGroup() {
		
		return ClassType.MELEE;
		
	}
	
	@Override
	public String getName() {
		
		return "swordsman";
		
	}

	@Override
	public KitType getKitType() {
		// TODO Auto-generated method stub
		return KitType.SWORDSMAN;
	}
	
}
