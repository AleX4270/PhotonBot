package events;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class VersionCommand extends ListenerAdapter
{



    public static void Show(GuildMessageReceivedEvent event)
    {

            EmbedBuilder ver = new EmbedBuilder();
            ver.setTitle("Informacje techniczne na temat bota:", null);
            ver.setColor(Color.orange);
            ver.setDescription("Wersja bota, ostatnia aktualizacja itd.");
            ver.addField("Aktualna wersja bota: ", "v0.4.5", false);
            ver.addField("Ostatnia aktualizacja: ", "28.01.2019", false);
            ver.addField("Twórca bota:", "AleX#2501", false);
            event.getChannel().sendMessage(ver.build()).queue();

    }
}
