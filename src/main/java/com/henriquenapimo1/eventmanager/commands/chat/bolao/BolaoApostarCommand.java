package com.henriquenapimo1.eventmanager.commands.chat.bolao;

import com.henriquenapimo1.eventmanager.Main;
import com.henriquenapimo1.eventmanager.utils.Utils;
import com.henriquenapimo1.eventmanager.utils.objetos.events.Bolao;
import com.henriquenapimo1.eventmanager.utils.objetos.CmdContext;

public class BolaoApostarCommand {

    public BolaoApostarCommand(CmdContext ctx) {
        Bolao b = Main.getMain().bolao;

        if(b == null) {
            ctx.reply("bolao.no-bolao", CmdContext.CommandType.BOLAO);
            return;
        }

        if(!ctx.getSender().hasPermission("eventmanager.bolao.apostar")) {
            ctx.reply("utils.no-permission", CmdContext.CommandType.BOLAO,"eventmanager.bolao.apostar");
            return;
        }

        if(!Utils.getBool("staff-apostar")) {
            if(ctx.getSender().hasPermission("eventmanager.staff") || ctx.getSender().hasPermission("eventmanager.mod") || ctx.getSender().hasPermission("eventmanager.admin")) {
                ctx.reply("bolao.apostar.staff", CmdContext.CommandType.BOLAO);
                return;
            }
        }

        b.apostar(ctx.getSender());
    }
}
