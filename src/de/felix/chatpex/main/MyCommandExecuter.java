package de.felix.chatpex.main;

import org.bukkit.entity.Player;

import java.util.HashMap;

/**
 * Created by felix on 01.01.2017.
 */
public class MyCommandExecuter {
    private static HashMap<String, IMyCommand> commands = new HashMap<>();
    public static void commandExec(String command, Player p){
        String[] cargs = null;
        if (command.contains(" ")){
            cargs = command.split(" ");
        }else{
            cargs[0] = command;
        }
        String args = "";
        if (args.length() >= 1){
            for(int i = 1; i < cargs.length; i++){
                args = args + " "+  cargs[i];
            }
        }
        if (commands.containsKey(cargs[0])){
            commands.get(cargs[0]).execute(args, p);
        }
    }
    public static void addCommand(String command, IMyCommand commandexec){
        commands.put(command, commandexec);
    }
}
