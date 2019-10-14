package de.felix.chatpex.main;

import org.bukkit.entity.Player;

import java.util.HashMap;

/**
 * Own solution to add Commands
 * Created by felix on 01.01.2017.
 */
public class MyCommandExecuter {
    private static HashMap<String, IMyCommand> commands = new HashMap<>();
    public static void commandExec(String command, Player p){
        boolean space = true;
        String[] cargs = null;
        if (command.contains(" ")){
            cargs = command.split(" ");
        }else{
            space = false;
        }
        String args = "";
        if (space){
            for(int i = 1; i < cargs.length; i++){
                args = args + " "+  cargs[i];
            }
        }else{
            args = null;
        }
        if (space && commands.containsKey(cargs[0].toLowerCase())){
            commands.get(cargs[0]).execute(args, p);
        }else if(commands.containsKey(command)){
            commands.get(command).execute(args, p);
        }
    }
    public static void addCommand(String command, IMyCommand commandexec){
        commands.put(command.toLowerCase(), commandexec);
    }
}
