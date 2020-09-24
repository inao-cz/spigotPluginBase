package me.inao.spigotbase.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class PlayerMoveEvent implements Listener {
    @EventHandler
    public void onMove(PlayerToggleSneakEvent e){
        e.getPlayer().sendMessage("Sneaking..");
    }
}
