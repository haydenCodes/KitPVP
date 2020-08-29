package me.icky.managers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import me.icky.player.GamePlayer;
import me.icky.player.PlayerManager;
import net.md_5.bungee.api.ChatColor;

public class SBManager {

	public static void setScoreboard(Player p) {
		
		ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
	    Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
	    
	    Objective objective = scoreboard.registerNewObjective("Test", "dummy");
	    objective.setDisplaySlot(DisplaySlot.SIDEBAR);
	    objective.setDisplayName(ChatColor.DARK_GRAY + ChatColor.BOLD.toString() + "UHC" + ChatColor.RED + ChatColor.BOLD.toString() + "Arcade");

        Score fillerOne = objective.getScore(" ");
        fillerOne.setScore(15);
	    
	    Team killCount = scoreboard.registerNewTeam("killcount");
	    killCount.addEntry(ChatColor.RED + "");
	    killCount.setPrefix(ChatColor.GRAY + "Kills: ");
	    killCount.setSuffix(ChatColor.RED + "0");
	    objective.getScore(ChatColor.RED + "").setScore(14);
	    
	    Team streakCount = scoreboard.registerNewTeam("streakcount");
	    streakCount.addEntry(ChatColor.GREEN + "");
	    streakCount.setPrefix(ChatColor.GRAY + "Streak: ");
	    streakCount.setSuffix(ChatColor.RED + "0");
	    objective.getScore(ChatColor.GREEN + "").setScore(13);
		
        Score fillerTwo = objective.getScore("  ");
        fillerTwo.setScore(12);
        
        Team level = scoreboard.registerNewTeam("level");
	    level.addEntry(ChatColor.BLUE + "");
	    level.setPrefix(ChatColor.GRAY + "Level: ");
	    level.setSuffix(ChatColor.RED + "1");
	    objective.getScore(ChatColor.BLUE + "").setScore(11);
	    
	    Team neededXP = scoreboard.registerNewTeam("neededxp");
	    neededXP.addEntry(ChatColor.DARK_RED + "");
	    neededXP.setPrefix(ChatColor.GRAY + "Needed XP: ");
	    neededXP.setSuffix(ChatColor.RED + "0");
	    objective.getScore(ChatColor.DARK_RED + "").setScore(10);
	    
        Team coins = scoreboard.registerNewTeam("coins");
        coins.addEntry(ChatColor.GOLD + "");
        coins.setPrefix(ChatColor.GRAY + "Coins: ");
        coins.setSuffix(ChatColor.RED + "0");
	    objective.getScore(ChatColor.GOLD + "").setScore(9);
	    
        Score fillerThree = objective.getScore("");
        fillerThree.setScore(8);
	    
        Score ipPlug = objective.getScore(ChatColor.GRAY + ChatColor.ITALIC.toString() + " uhcdungeons.net ");
        ipPlug.setScore(7);
        
	    p.setScoreboard(scoreboard);
	    
	}
	
	@SuppressWarnings("unused")
	public static void updateScoreboard(Player p) {
		
		Scoreboard scoreboard = p.getScoreboard();
		
		Team killCount = scoreboard.getTeam("killcount");
		Team streakCount = scoreboard.getTeam("streakcount");
		Team level = scoreboard.getTeam("level");
		Team neededXP = scoreboard.getTeam("neededxp");
		Team coins = scoreboard.getTeam("coins");
		
		GamePlayer player = PlayerManager.getInstance().getGamePlayer(p.getUniqueId());
		
		streakCount.setSuffix(ChatColor.RED.toString() + player.getCurrentStreak());
		
	}
	
}
