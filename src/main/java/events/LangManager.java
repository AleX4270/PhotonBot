package events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class LangManager extends ListenerAdapter
{
    public static String Show(GuildMessageReceivedEvent e, String msg[])
    {
        String mes = "";

        if(msg.length < 1 || msg.length > 2)
        {
            e.getChannel().sendMessage("Bledne uzycie komendy! Wpisz ?lang polish lub ?lang english").queue();
        }
        else
        {
            for(int i = 0; i < msg.length; i++)
            {
                mes += msg[i];
                mes += " ";
            }

        }

        return mes;
    }
}
