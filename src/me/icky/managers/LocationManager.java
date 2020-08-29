package me.icky.managers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class LocationManager {
	
	private static final LocationManager instance = new LocationManager();
	
	public static LocationManager getInstance() {
		
		return instance;
		
	}
	
	private LocationManager() {}
	
	public World getMainWorld() {
		
		return Bukkit.getWorld("lobby");
		
	}
	
	public Location getSpawnLocation() {
		
		return new Location(this.getMainWorld(), 0.5, 82, 0.5);
		
	}
	
}
