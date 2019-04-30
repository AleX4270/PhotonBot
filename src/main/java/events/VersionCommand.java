package events;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class VersionCommand extends ListenerAdapter
{



    public static void ShowPl(GuildMessageReceivedEvent event)
    {

            EmbedBuilder ver = new EmbedBuilder();
            ver.setTitle("Informacje techniczne na temat bota:", null);
            ver.setColor(Color.RED);
            ver.setDescription("Wersja bota, ostatnia aktualizacja itd.");
            ver.addField("Aktualna wersja bota: ", "v.0.5.0 [The Red Update]", false);
            ver.addField("Ostatnia aktualizacja: ", "29.04.2019", false);
            ver.addField("Dodano:", "Wybór języków[PL, ENG]", false);
            ver.addField("Twórca bota:", "AleX#2501", false);
            ver.addField("Betatesterzy:", "filipton12#2364", false);
            event.getChannel().sendMessage(ver.build()).queue();

    }

    public static void ShowEng(GuildMessageReceivedEvent event)
    {

        EmbedBuilder ver = new EmbedBuilder();
        ver.setTitle("A piece of technical information about the bot:", null);
        ver.setColor(Color.RED);
        ver.setDescription("Bot version, last update, etc.");
        ver.addField("Version: ", "v.0.5.0 [The Red Update]", false);
        ver.addField("Last Update: ", "29.04.2019", false);
        ver.addField("Changelog:", "Language Selector[PL, ENG]", false);
        ver.addField("Bot creator:", "AleX#2501", false);
        ver.addField("Betatesters:", "filipton12#2364", false);
        event.getChannel().sendMessage(ver.build()).queue();

    }
}
