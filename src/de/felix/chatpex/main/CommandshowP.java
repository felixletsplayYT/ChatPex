package de.felix.chatpex.main;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by felix on 01.01.2017.
 */
public class CommandshowP implements  IMyCommand {
    @Override
    public void execute(String args, Player p) {
        if (args.length() == 1){

        }else{
            p.sendMessage(ChatColor.RED + "Wrong Parameter");
        }
    }
}
