package me.inao.reaction.commands.command;

import me.inao.reaction.Main;
import me.inao.reaction.Message;
import me.inao.reaction.Permission;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Test extends Command {
    private Main instance;
    public Test(String name, Main main){
        super(name);
        this.setDescription("Easy af command");
        this.setPermission(Permission.COMMAND_TEST.get());
        this.instance = main;
    }

    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        if ((commandSender instanceof Player)) {
            if(this.testPermissionSilent(commandSender)){
                commandSender.sendMessage(Message.GENERIC_SUCCESS.get());
            }else{
                commandSender.sendMessage(Message.PERMS_NOPERMS.get());
            }
        }
        return true;
    }
}
