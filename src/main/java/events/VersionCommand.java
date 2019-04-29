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
            ver.setColor(Color.RED);
            ver.setDescription("Wersja bota, ostatnia aktualizacja itd.");
            ver.addField("Aktualna wersja bota: ", "v.0.5.0 [The Red Update]", false);
            ver.addField("Ostatnia aktualizacja: ", "27.04.2019", false);
            ver.addField("Twórca bota:", "AleX#2501", false);
            event.getChannel().sendMessage(ver.build()).queue();

    }
}
