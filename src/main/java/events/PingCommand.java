package events;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class PingCommand extends ListenerAdapter
{

    public static void ShowPl(GuildMessageReceivedEvent event)
    {

        long pong = event.getJDA().getPing();
        String ping = Long.toString(pong);

        EmbedBuilder pin = new EmbedBuilder();
        pin.setTitle(":ping_pong: PONG :ping_pong: ");
        pin.setColor(Color.RED);
        pin.addField("Aktualny ping bota: ", ping, false );
        event.getChannel().sendMessage(pin.build()).queue();


    }

    public static void ShowEng(GuildMessageReceivedEvent event)
    {

        long pong = event.getJDA().getPing();
        String ping = Long.toString(pong);

        EmbedBuilder pin = new EmbedBuilder();
        pin.setTitle(":ping_pong: PONG :ping_pong: ");
        pin.setColor(Color.RED);
        pin.addField("Actual bot ping: ", ping, false );
        event.getChannel().sendMessage(pin.build()).queue();


    }
}
