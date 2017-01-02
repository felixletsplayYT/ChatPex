package de.felix.chatpex.main;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import ru.tehkode.permissions.bukkit.PermissionsEx;

/**
 * Main Class
 * Created by felix on 01.01.2017.
 */
public class Main extends JavaPlugin{


    @Override
    public void onEnable() {
        MyCommandExecuter.addCommand("/showP", new CommandshowP());
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
