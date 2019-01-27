package bot.status;

import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class BotStatus extends ListenerAdapter
{
    @Override
    public void onReady(ReadyEvent evnt)
    {
        evnt.getJDA().getPresence().setGame(Game.of(Game.GameType.DEFAULT, "100% in Java :)"));
    }
}
