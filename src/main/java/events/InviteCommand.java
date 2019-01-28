package events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class InviteCommand extends ListenerAdapter
{
    public static void Show(GuildMessageReceivedEvent event, String msg[])
    {
        if(msg.length < 2 || msg.length > 2)
        {
            event.getChannel().sendMessage("**Aby użyć tej komendy właściwie wpisz: ?invite create**").queue();

        }
        else if(msg[1].equalsIgnoreCase("create"))
        {
            event.getChannel().sendMessage("**Stworzono pomyslnie link zaproszenia:** " + event.getChannel().createInvite().setMaxAge(3600).complete().getURL()).queue();
            event.getChannel().sendMessage("**Zaproszenie jest ważne przez godzinę!**").queue();
        }
    }
}
