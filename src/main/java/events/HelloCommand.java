package events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageDeleteEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class HelloCommand extends ListenerAdapter
{
    private String pref = "?";

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event)
    {
        String messageSent = event.getMessage().getContentRaw();
        String channelName = event.getChannel().getName();
        String messageAuthor = event.getAuthor().getName();
        String authorName = event.getMember().getUser().getName();
        String serverName = event.getGuild().getName();

        if(event.getAuthor().isBot())
        {
            return;
        }

        if(messageSent.equalsIgnoreCase(pref + "witaj")) //komenda witajaca
        {
            event.getChannel().sendMessage("**Witaj, " + authorName + "!**").queue();
        }
    }
}
