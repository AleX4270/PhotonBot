package events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class CalculateCommand extends ListenerAdapter
{
    private String pref = "?";

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event)
    {
        if(event.getAuthor().isBot())
        {
            return;
        }

        String messageSent = event.getMessage().getContentRaw();
        String channelName = event.getChannel().getName();
        String messageAuthor = event.getAuthor().getName();
        String authorName = event.getMember().getUser().getName();
        String serverName = event.getGuild().getName();

        String message[] = event.getMessage().getContentRaw().split(" ");

        if(message[0].equalsIgnoreCase(pref + "kalkulator")) //glowna czesc komendy
        {
            if(message[1].equalsIgnoreCase("dodaj")) //dodawanie dwoch liczb
            {
                int a,b,r;
                String result;
                a = Integer.parseInt(message[2]);
                b = Integer.parseInt(message[3]);
                r = (a + b);

                result = Integer.toString(r);

                event.getChannel().sendMessage("Wynik tego dzialania to: " + result).queue();

            }
        }

    }
}
