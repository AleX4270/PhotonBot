package events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class ShdCommand extends ListenerAdapter
{
    public static void Shutdown(GuildMessageReceivedEvent e)
    {
        e.getChannel().sendMessage("Wylaczanie bota...");
        System.exit(0);
    }
}
