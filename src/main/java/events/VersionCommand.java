package events;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class VersionCommand extends ListenerAdapter
{
    private String pref = "?";

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event)
    {
        if(event.getAuthor().isBot())
        {
            return;
        }

        String messageSent = event.getMessage().getContentRaw();
        String channelName = event.getChannel().getName();
        String messageAuthor = event.getAuthor().getName();
        String authorName = event.getMember().getUser().getName();
        String serverName = event.getGuild().getName();

        if(messageSent.equalsIgnoreCase(pref + "wersja"))
        {
            EmbedBuilder ver = new EmbedBuilder();
            ver.setTitle("Informacje techniczne na temat bota:", null);
            ver.setColor(Color.orange);
            ver.setDescription("Wersja bota, ostatnia aktualizacja itd.");
            ver.addField("Aktualna wersja bota: ", "v0.4.3", false);
            ver.addField("Ostatnia aktualizacja: ", "27.01.2019", false);
            ver.addField("Twórca bota:", "AleX#2501", false);
            event.getChannel().sendMessage(ver.build()).queue();
        }
    }
}
