package de.felix.chatpex.main;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

/**
 * Listener
 * Created by felix on 01.01.2017.
 */
public class Listners implements Listener {

    public void commandlistner(PlayerCommandPreprocessEvent e){
        MyCommandExecuter.commandExec(e.getMessage());
    }

}
