package me.icky.player;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class GamePlayer {
	
	private final UUID uuid;
	private boolean playing;
	private int kills = 0;
	private int currentStreak = 0;
	
	public GamePlayer(UUID uuid) {
		
		this.uuid = uuid;
		
	}
	
	public UUID getUUID() {
		
		return uuid;
		
	}
	
	public Player getBukkitPlayer() {
		
		return Bukkit.getServer().getPlayer(uuid);
		
	}
	
	public void addKill() {
		
		kills++;
		
	}
	
	public int getKills() {
		
		return kills;
		
	}
	
	public void addCurrentStreak() {

		currentStreak++;
		
	}
	
	public void resetCurrentStreak() {
		
		currentStreak = 0;
		
	}
	
	public int getCurrentStreak() {

		return currentStreak;
		
	}	
	
	public boolean isPlaying() {
		
		return playing;
		
	}
	
	public void setPlaying(boolean playing) {
		
		this.playing = playing;
		
	}
	
}
