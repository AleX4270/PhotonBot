package events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class ShdCommand extends ListenerAdapter
{
    public static void Shutdown(GuildMessageReceivedEvent e)
    {
        if(Handler.language.equalsIgnoreCase("Polish"))
        {
            e.getChannel().sendMessage("Wylaczanie bota...");
        }
        else
        {
            e.getChannel().sendMessage("Shutting down the bot...");
        }

        System.exit(0);
    }
}
