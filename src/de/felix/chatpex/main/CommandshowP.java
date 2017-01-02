package de.felix.chatpex.main;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

/**Get the Prefix of an Person
 *
 * Created by felix on 01.01.2017.
 */
public class CommandshowP implements  IMyCommand {
    @Override
    public void execute(String args, Player p) {
        System.out.println("test");
        if (args != null){
            PermissionsEx pex = (PermissionsEx) PermissionsEx.getPlugin();
            pex.getPermissionsManager().getUser(args.split(" ")[1]).getPrefix();
            p.sendMessage("Der User " + args.split(" ")[1] + " hat den Prefix " + pex.getPermissionsManager().getUser(args.split(" ")[1]).getPrefix("world"));
        }else{
            p.sendMessage(ChatColor.RED + "Wrong Parameter");
        }
    }
}
