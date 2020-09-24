package me.inao.spigotbase;

import me.inao.spigotbase.util.Loader;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        sayConsole("Welcome to &binao's special Base plugin!");
        Loader loader = new Loader(this);
        loader.loadCommands();
        loader.loadEvents();
    }

    @Override
    public void onDisable() {
        sayConsole("Goodbye &cfriend &f:(");
    }

    public void sayConsole(String message){
        Bukkit.getConsoleSender().sendMessage(message.replaceAll("&", "§"));
    }

}
