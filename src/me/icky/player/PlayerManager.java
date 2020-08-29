package me.icky.player;

import java.util.ArrayList;
import java.util.UUID;

public class PlayerManager {
	
	private static PlayerManager instance = new PlayerManager();
	private ArrayList<GamePlayer> gamePlayers = new ArrayList<GamePlayer>();
	
	public static PlayerManager getInstance() {
		
		return instance;
		
	}
	
	public PlayerManager() {}
	
	public void addGamePlayer(GamePlayer gamePlayer) {
		
		gamePlayers.add(gamePlayer);
		
	}
	
	public void removeGamePlayer(GamePlayer gamePlayer) {
		
		if(gamePlayers.contains(gamePlayer)) gamePlayers.remove(gamePlayer);
		
	}
	
	public ArrayList<GamePlayer> getGamePlayers() {
		
		return gamePlayers;
		
	}
	
	public GamePlayer getGamePlayer(UUID uuid) {
		
		for(GamePlayer gamePlayer : gamePlayers) {
			
			if(gamePlayer.getUUID().equals(uuid)) {
				
				return gamePlayer;
				
			}
			
		}
		
		return null;
		
	}
	
}
