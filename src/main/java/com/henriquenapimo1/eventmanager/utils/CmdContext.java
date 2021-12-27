package com.henriquenapimo1.eventmanager.utils;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdContext {

    private Player s;
    private Command c;
    private String[] a;

    public CmdContext(CommandSender sender, Command command, String[] args) {
        this.s = (Player) sender;
        this.c = command;
        this.a = args;
    }

    public Command getCommand() {
        return c;
    }

    public Player getSender() {
        return s;
    }

    public String[] getArgs() {
        return a;
    }

    public String getArg(int i) {
        return a[i];
    }

    public void reply(String msg) {
        s.sendMessage(Utils.getPref() + " §f" + msg);
    }
}
