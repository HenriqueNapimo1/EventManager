package com.henriquenapimo1.eventmanager.commands.chat.quiz;

import com.henriquenapimo1.eventmanager.Main;
import com.henriquenapimo1.eventmanager.utils.objetos.CmdContext;
import com.henriquenapimo1.eventmanager.utils.objetos.Quiz;

public class SetRespostaCommand {

    public SetRespostaCommand(CmdContext ctx) {
        Quiz quiz = Main.getMain().quiz;

        if(quiz == null) {
            ctx.reply("quiz.setresposta.error", CmdContext.CommandType.QUIZ);
            return;
        }

        if(ctx.getArgs().length == 1) {
            ctx.reply("args", CmdContext.CommandType.QUIZ,"/quiz setresposta [resposta]");
            return;
        }

        String resp = String.join(" ",ctx.getArgs())
                .replace("setresposta ","")
                .replaceAll(".$", "");

        ctx.reply("quiz.setresposta.success", CmdContext.CommandType.QUIZ);
        quiz.start(resp);
    }
}
