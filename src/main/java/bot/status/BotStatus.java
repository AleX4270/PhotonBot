package bot.status;

import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class BotStatus extends ListenerAdapter
{
    private static String defaultStatus = "?help";
    public static String changedStatus = "?help";


    public static void Status(GuildMessageReceivedEvent evnt)
    {

        if(changedStatus == defaultStatus)
        {
            evnt.getJDA().getPresence().setGame(Game.of(Game.GameType.DEFAULT, defaultStatus));
        }
        else
        {
            evnt.getJDA().getPresence().setGame(Game.of(Game.GameType.DEFAULT, changedStatus));
        }

    }

    public static void ChangeDefault(ReadyEvent event)
    {
        event.getJDA().getPresence().setGame(Game.of(Game.GameType.DEFAULT, defaultStatus));
    }
}
