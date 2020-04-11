package me.inao.reaction.commands;

import me.inao.reaction.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.help.GenericCommandHelpTopic;
import org.bukkit.help.HelpTopic;
import org.bukkit.help.IndexHelpTopic;
import org.reflections.Reflections;
import java.lang.reflect.Field;
import java.util.*;

public class Loader {
    private final Main main;
    public Loader(Main main){
        this.main = main;
        load();
    }

    private void load(){
        CommandMap map = null;
        try{
            Field cmdMap = Bukkit.getPluginManager().getClass().getDeclaredField("commandMap");
            cmdMap.setAccessible(true);
            map = (CommandMap) cmdMap.get(Bukkit.getPluginManager());
        }catch (Exception e){
            e.printStackTrace();
        }
        HashSet<Command> coms = new HashSet<>();
        Reflections reflections = new Reflections("me.inao.reaction.commands.command");
        Set<Class<? extends Command>> commands = reflections.getSubTypesOf(Command.class);
        for(Class<?extends Command> cls : commands){
            try{
                Command command = cls.getDeclaredConstructor(new Class[]{String.class, Main.class}).newInstance(new Object[]{cls.getSimpleName().toLowerCase(), main});
                map.register(cls.getSimpleName().toLowerCase(), command);
                coms.add(command);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        genHelp(coms);
    }
    private void genHelp(Collection<Command> cmds){
        List<HelpTopic> topics = new ArrayList<>();
        for(Command c : cmds){
            topics.add(new GenericCommandHelpTopic(c));
        }
        Bukkit.getHelpMap().addTopic(new IndexHelpTopic(
                "Reactions",
                "Reactions (made by inao)",
                "reactions.help",
                topics,
                "Reactions Help"
        ));
    }
}
