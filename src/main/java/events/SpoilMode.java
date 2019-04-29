package events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class SpoilMode extends ListenerAdapter
{
    static boolean spoilMode = false;

    public static void Show(GuildMessageReceivedEvent e)
    {
        if(spoilMode == false)
        {
            spoilMode = true;
            e.getChannel().sendMessage("Anti Spoiler Mode Activated!").queue();
        }
        else if(spoilMode == true)
        {
            spoilMode = false;
            e.getChannel().sendMessage("Anti Spoiler Mode Deactivated!").queue();
        }
    }
}
