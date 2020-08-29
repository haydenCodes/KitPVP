package me.icky;

import java.util.Arrays;

import org.apache.commons.lang3.Validate;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.icky.listeners.DeathListener;
import me.icky.listeners.ProtectionListeners;
import me.icky.managers.GameManager;
import me.icky.managers.SBManager;
import net.md_5.bungee.api.ChatColor;

public class Kit extends JavaPlugin {

    private static Kit instance;

    public static Kit getInstance() {
        return instance;
    }

    public Kit() {
        Validate.isTrue(instance == null, "Singleton already initialized!");

        instance = this;
    }

    @Override
    public void onEnable() {

        // Register listeners
        Arrays.asList(
                GameManager.getInstance(),
                new ProtectionListeners(),
                new DeathListener()
        ).forEach(listener -> Bukkit.getPluginManager().registerEvents(listener, this));
    
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                    SBManager.updateScoreboard(p);
                }
            }

        }.runTaskTimer(this, 0, 20);
    
    }
    
    @Override
    public void onDisable() {
        
    }

    public String getPrefix() {
        return ChatColor.AQUA + ChatColor.BOLD.toString() + "MCDungeons" + ChatColor.GRAY + " >> ";
    }

}
