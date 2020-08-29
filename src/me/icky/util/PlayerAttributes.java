package me.icky.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.icky.player.GamePlayer;
import me.icky.player.PlayerManager;

public class PlayerAttributes {

    public static void reset(Player player) {
        player.setMaxHealth(40);
        player.setFoodLevel(20);
        player.setHealth(player.getMaxHealth());
        player.setExp(0);
        player.setTotalExperience(0);
        player.setLevel(0);
        player.setGameMode(Bukkit.getServer().getDefaultGameMode());
        player.getInventory().clear();
        player.getInventory().setArmorContents(new ItemStack[4]);
         
        GamePlayer p = PlayerManager.getInstance().getGamePlayer(player.getUniqueId());
        
        if(p != null) p.resetCurrentStreak();
        
    }

}
