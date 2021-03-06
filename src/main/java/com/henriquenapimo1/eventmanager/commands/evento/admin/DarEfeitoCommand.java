package com.henriquenapimo1.eventmanager.commands.evento.admin;

import com.henriquenapimo1.eventmanager.Main;
import com.henriquenapimo1.eventmanager.utils.objetos.events.Evento;
import com.henriquenapimo1.eventmanager.utils.objetos.CmdContext;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DarEfeitoCommand {

    public DarEfeitoCommand(CmdContext ctx) {
        Evento evento = Main.getMain().evento;

        if(evento == null) {
            ctx.reply("evento.no-evento", CmdContext.CommandType.EVENTO);
            return;
        }

        ItemStack item = ctx.getSender().getInventory().getItemInMainHand();
        if(item.getType().equals(Material.AIR)) {
            ctx.reply("evento.dar.no-item", CmdContext.CommandType.EVENTO);
            return;
        }

        if(!Arrays.asList(Material.POTION,Material.SPLASH_POTION,Material.LINGERING_POTION).contains(item.getType())) {
            ctx.reply("evento.dar.efeito.not-potion", CmdContext.CommandType.EVENTO);
            return;
        }

        PotionMeta meta = (PotionMeta) item.getItemMeta();
        assert meta != null;

        List<PotionEffect> effects = new ArrayList<>(meta.getCustomEffects());

        PotionEffectType pType = meta.getBasePotionData().getType().getEffectType();

        if(pType == null) {
            ctx.reply("evento.dar.efeito.error", CmdContext.CommandType.EVENTO);
            return;
        }

        PotionEffect efeito = new PotionEffect(pType,10000,1,false,false);
        effects.add(efeito);

        evento.darEfeito(effects);

        ctx.reply("evento.dar.success", CmdContext.CommandType.EVENTO);
    }
}
