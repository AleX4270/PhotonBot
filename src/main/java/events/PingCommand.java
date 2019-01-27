package events;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class PingCommand extends ListenerAdapter
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

        if(messageSent.equalsIgnoreCase(pref + "ping"))
        {
            long pong = event.getJDA().getPing();
            String ping = Long.toString(pong);

            EmbedBuilder pin = new EmbedBuilder();
            pin.setTitle(":ping_pong: PONG :ping_pong: ");
            pin.setColor(Color.CYAN);
            pin.addField("Aktualny ping bota: ", ping, false );
            event.getChannel().sendMessage(pin.build()).queue();
        }

    }
}
