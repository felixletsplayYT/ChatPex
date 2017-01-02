package de.felix.chatpex.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

/**
 * Listener
 * Created by felix on 01.01.2017.
 */
public class Listners implements Listener {

    public void commandlistner(PlayerCommandPreprocessEvent e){
        MyCommandExecuter.commandExec(e.getMessage(), e.getPlayer());
    }

    public void chat(AsyncPlayerChatEvent e){
        Bukkit.broadcastMessage(Main.getPrefix(e.getPlayer()) + e.getPlayer().getName() +" -> " + e.getMessage());
        e.setCancelled(true);
    }
    public void onJoin(PlayerJoinEvent e){
        e.setJoinMessage(Main.getPrefix(e.getPlayer()) + " " +e.getPlayer() + " joined the game.");
        Scoreboard sb = Bukkit.getServer().getScoreboardManager().getMainScoreboard();
        if (sb.getTeam(Main.getPrefix(e.getPlayer())) == null){
            sb.registerNewTeam(Main.getPrefix(e.getPlayer()));
        }
        Team team = sb.getTeam(Main.getPrefix(e.getPlayer()));
        if (Main.getPrefix(e.getPlayer()).length() < 19){
            team.setPrefix(Main.getPrefix(e.getPlayer()));
        }else{
            e.getPlayer().sendMessage(ChatColor.RED + "ERROR WHILE TRYING TO SET PREFIX. REPORT TO A TEAM MEMBER!");
        }
        team.addPlayer(e.getPlayer());
    }

    public void onLeft(PlayerQuitEvent e){
        e.setQuitMessage(Main.getPrefix(e.getPlayer()) + " " +e.getPlayer() + " left the game.");
    }

}
