package events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class InviteCommand extends ListenerAdapter
{
    public static void Show(GuildMessageReceivedEvent event, String msg[])
    {
        if(msg.length < 2 || msg.length > 2)
        {
            if(Handler.language.equalsIgnoreCase("Polish"))
            {
                event.getChannel().sendMessage("**Aby użyć tej komendy właściwie wpisz: ?zaproszenie stworz**").queue();
            }
            else
            {
                event.getChannel().sendMessage("**To use that command properly type: ?invite create**").queue();
            }


        }
        else if(msg[1].equalsIgnoreCase("stworz") || (msg[1].equalsIgnoreCase("create") && Handler.language.equalsIgnoreCase("English")))
        {
            if(Handler.language.equalsIgnoreCase("Polish"))
            {
                event.getChannel().sendMessage("**Stworzono pomyslnie link zaproszenia:** " + event.getChannel().createInvite().setMaxAge(3600).complete().getURL()).queue();
                event.getChannel().sendMessage("**Zaproszenie jest ważne przez godzinę!**").queue();
            }
            else
            {
                event.getChannel().sendMessage("**Invite created:** " + event.getChannel().createInvite().setMaxAge(3600).complete().getURL()).queue();
                event.getChannel().sendMessage("**This invite is valid for one hour!**").queue();
            }

        }
    }
}
