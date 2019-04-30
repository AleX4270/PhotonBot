package events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageDeleteEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class HelloCommand extends ListenerAdapter
{
    private static String pref = "?";


    public static void ShowPl(GuildMessageReceivedEvent event)
    {
        event.getChannel().sendMessage("**Witaj, " + event.getAuthor().getName() + "!**").queue();
    }

    public static void ShowEng(GuildMessageReceivedEvent event)
    {
        event.getChannel().sendMessage("**Hello, " + event.getAuthor().getName() + "!**").queue();
    }
}
