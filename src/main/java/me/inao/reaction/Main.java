package me.inao.reaction;

import me.inao.reaction.commands.Loader;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        sayConsole("Welcome to &binao's special Reaction plugin!");
        new Loader(this);
    }

    @Override
    public void onDisable() {
        sayConsole("Goodbye &cfriend &f:(");
    }

    public void sayConsole(String message){
        Bukkit.getConsoleSender().sendMessage(message.replaceAll("&", "§"));
    }

}
