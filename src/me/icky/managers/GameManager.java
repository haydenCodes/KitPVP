package me.icky.managers;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.icky.Kit;
import me.icky.kits.KitManager;
import me.icky.player.GamePlayer;
import me.icky.player.PlayerManager;
import me.icky.util.ItemBuilder;
import me.icky.util.PlayerAttributes;
import net.md_5.bungee.api.ChatColor;

public class GameManager implements Listener {
	
	private static final GameManager instance = new GameManager();
	
	public static GameManager getInstance() {
		
		return instance;
	
	}
	
	private GameManager() {}
	
	@EventHandler
	public void onJoinEvent(PlayerJoinEvent e) {
		
		e.setJoinMessage("");
		
		final Player p = e.getPlayer();
		
		new BukkitRunnable() {
			
			@Override
            public void run() {
				
				if(p != null) {
					
					p.teleport(LocationManager.getInstance().getSpawnLocation());
					SBManager.setScoreboard(p);
					PlayerAttributes.reset(p);
					p.getInventory().setItem(4, new ItemBuilder(Material.COMPASS).withName(ChatColor.GREEN + "Server Selector").build());
											
					if(PlayerManager.getInstance().getGamePlayer(p.getUniqueId()) == null) {
						GamePlayer player = new GamePlayer(p.getUniqueId());
						PlayerManager.getInstance().addGamePlayer(player);
					}
											
				}
				
			}
			
		}.runTaskLater(Kit.getInstance(), 0L);
		
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		
		if(!PlayerManager.getInstance().getGamePlayer(e.getPlayer().getUniqueId()).isPlaying()) {
						
			if(e.getPlayer().getLocation().getY() < 40) {
				
				GamePlayer player = PlayerManager.getInstance().getGamePlayer(e.getPlayer().getUniqueId());
				player.setPlaying(true);
				PlayerAttributes.reset(player.getBukkitPlayer());
				KitManager.getInstance().getPlayersKit(player).giveTo(player.getBukkitPlayer());
				
			}
			
		}
		
	}
		
}
