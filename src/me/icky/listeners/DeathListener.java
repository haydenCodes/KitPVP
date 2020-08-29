package me.icky.listeners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import me.icky.kits.KitManager;
import me.icky.managers.LocationManager;
import me.icky.player.GamePlayer;
import me.icky.player.PlayerManager;
import me.icky.util.ItemBuilder;
import me.icky.util.PlayerAttributes;
import net.md_5.bungee.api.ChatColor;

public class DeathListener implements Listener {

	int MAX_SHARPLEVEL = 2;
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
				
		
		e.getDrops().clear();
		//e.getDrops().add(new ItemStack(Material.SKULL_ITEM, 1, (byte) 3));		
		GamePlayer deadPlayer = PlayerManager.getInstance().getGamePlayer(e.getEntity().getUniqueId());
		deadPlayer.setPlaying(false);
		PlayerAttributes.reset(deadPlayer.getBukkitPlayer());
		KitManager.getInstance().getPlayersKit(deadPlayer).giveTo(deadPlayer.getBukkitPlayer());
		deadPlayer.getBukkitPlayer().teleport(LocationManager.getInstance().getSpawnLocation());

		
		if(e.getEntity().getKiller() != null) {
			
			GamePlayer killerPlayer = PlayerManager.getInstance().getGamePlayer(e.getEntity().getKiller().getUniqueId());
			killerPlayer.addCurrentStreak();
			
		}
		
		PlayerAttributes.reset(deadPlayer.getBukkitPlayer());
				
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		
		e.setQuitMessage("");
		
		Random rand = new Random();
		
		List<ItemStack> drops = new ArrayList<ItemStack>();
		
		List<ItemStack> armorPieces = Arrays.asList(new ItemStack[]{
				new ItemStack(Material.DIAMOND_HELMET),
				new ItemStack(Material.DIAMOND_CHESTPLATE),
				new ItemStack(Material.DIAMOND_LEGGINGS),
				new ItemStack(Material.DIAMOND_BOOTS)});
		
		List<ItemStack> extraDrops = new ArrayList<ItemStack>();
		
		for(ItemStack piece : drops) {
			
			for(ItemStack diamondPiece : armorPieces) {
				
				if(piece.getType() == diamondPiece.getType()) {
					
					//10% chance of dropping one of their diamond pieces
					if(rand.nextFloat() <= .1f) {
						
						extraDrops.add(diamondPiece);
						
					}
					
				}
				
			}
			
		}
		
		drops.clear();
		//e.getDrops().add(new ItemStack(Material.SKULL_ITEM, 1, (byte) 3));
		extraDrops.forEach((itm) -> drops.add(itm));
		
		GamePlayer deadPlayer = PlayerManager.getInstance().getGamePlayer(e.getPlayer().getUniqueId());
		deadPlayer.setPlaying(false);
		PlayerAttributes.reset(deadPlayer.getBukkitPlayer());
		KitManager.getInstance().getPlayersKit(deadPlayer).giveTo(deadPlayer.getBukkitPlayer());
		deadPlayer.getBukkitPlayer().teleport(LocationManager.getInstance().getSpawnLocation());
		
		PlayerAttributes.reset(deadPlayer.getBukkitPlayer());
		deadPlayer.getBukkitPlayer().getInventory().setItem(4, new ItemBuilder(Material.COMPASS).withName(ChatColor.GREEN + "Server Selector").build());

	}
	
}
