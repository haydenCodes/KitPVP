package me.icky.kits;


import gg.glade.core.game.kit.KitType;
import gg.glade.core.game.kit.data.KitProfileManager;
import me.icky.kits.impl.Swordsman;
import me.icky.player.GamePlayer;

public class KitManager {
	
	private static KitManager instance = new KitManager();
	
	public static KitKitManagerManager getInstance() {
		
		return instance;
		
	}
	
	public KitManager() {}
	
	public Kit getPlayersKit(GamePlayer player) {
		
		if(KitProfileManager.getInstance().getProfile(player.getUUID()).getSelected() == KitType.SWORDSMAN) {
			
			return new Swordsman();
			
		}
		
		return new Swordsman();
		
	}
	
}
