package de.felix.chatpex.main;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import ru.tehkode.permissions.bukkit.PermissionsEx;

/**
 * Main Class
 * Created by felix on 01.01.2017.
 */
public class Main extends JavaPlugin{
    public static void main(String[] args){
        MyCommandExecuter.addCommand("shoeP", new CommandshowP());
    }

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new Listners(), this);
    }

    @Override
    public void onDisable() {

    }

    public static String getPrefix(Player p){
        PermissionsEx pex = (PermissionsEx) PermissionsEx.getPlugin();
        return pex.getPermissionsManager().getUser(p.getName()).getPrefix();
    }
}
