package events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class StatusCommand extends ListenerAdapter
{
    static String newStatus;

    public static String Change(GuildMessageReceivedEvent event, String msg[])
    {
        newStatus = "";

        for(int i = 1; i < msg.length; i++)
        {
            newStatus += msg[i];
            newStatus += " ";
        }

        return newStatus;
    }
}
