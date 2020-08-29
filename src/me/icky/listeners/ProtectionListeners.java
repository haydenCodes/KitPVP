package me.icky.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

import me.icky.player.GamePlayer;
import me.icky.player.PlayerManager;
import me.icky.util.ItemBuilder;
import net.md_5.bungee.api.ChatColor;

public class ProtectionListeners implements Listener {
	
	@EventHandler
	public void onPlayerDamage(EntityDamageEvent e) {
		
		if(e.getEntity() instanceof Player) {
			
			Player p = (Player) e.getEntity();
			
			if(!PlayerManager.getInstance().getGamePlayer(p.getUniqueId()).isPlaying()) {
				
				e.setCancelled(true);
				return;
				
			}
			
			if(e.getCause() == DamageCause.FALL) {
				
				e.setCancelled(true);
				
			}
			
		}
		
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		
		ItemStack compass = new ItemBuilder(Material.COMPASS).withName(ChatColor.GREEN + "Server Selector").build();
		
		if(e.getItemDrop().getItemStack().equals(compass)) {
			
			e.setCancelled(true);
			
		}
		
	}
	
	@EventHandler
	public void onInvInteract(InventoryClickEvent e) {
		
		Player p = (Player) e.getWhoClicked();
		GamePlayer player = PlayerManager.getInstance().getGamePlayer(p.getUniqueId());
		
		if(!player.isPlaying()) {
			
			e.setCancelled(true);
			
		}
		
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		
		e.setCancelled(true);
		
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		
		e.setCancelled(true);
		
	}
	
	@EventHandler
	public void foodLoss(FoodLevelChangeEvent e) {
		
		e.setCancelled(true);
		
	}
	
}
