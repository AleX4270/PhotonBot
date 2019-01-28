package events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class SayCommand extends ListenerAdapter
{
    public static void Show(GuildMessageReceivedEvent event, String msg[])
    {

        String mes = "";
        for(int i = 1; i < msg.length; i++)
        {
            mes += msg[i];
            mes += " ";
        }

        event.getChannel().sendMessage(mes).queue();

    }
}
