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
        boolean leertaste = true;
        String[] cargs = null;
        if (command.contains(" ")){
            cargs = command.split(" ");
        }else{
            leertaste = false;
        }
        String args = "";
        if (leertaste){
            for(int i = 1; i < cargs.length; i++){
                args = args + " "+  cargs[i];
            }
        }else{
            args = null;
        }
        System.out.println(leertaste);
        System.out.println(commands.keySet().toArray()[0]);
        if (leertaste && commands.containsKey(cargs[0].toLowerCase())){
            System.out.println("test");
            commands.get(cargs[0]).execute(args, p);
        }else if(commands.containsKey(command)){
            commands.get(command).execute(args, p);
        }
    }
    public static void addCommand(String command, IMyCommand commandexec){
        commands.put(command.toLowerCase(), commandexec);
    }
}
