package de.felix.chatpex.main;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main Class
 * Created by felix on 01.01.2017.
 */
public class Main extends JavaPlugin{
    public static void main(String[] args){
        MyCommandExecuter.addCommand("/showp", new CommandshowP());
        MyCommandExecuter.commandExec("test krass");
    }

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new Listners(), this);
    }

    @Override
    public void onDisable() {

    }
}
