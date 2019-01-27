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
                double a,b,r;
                String result;
                a = Double.parseDouble(message[2]);
                b = Double.parseDouble(message[3]);
                r = (a + b);

                result = Double.toString(r);

                event.getChannel().sendMessage("**Wynik tego dzialania to:** " + result).queue();

            }
            else if(message[1].equalsIgnoreCase("odejmij"))
            {
                double a,b,r;
                String result;
                a = Double.parseDouble(message[2]);
                b = Double.parseDouble(message[3]);
                r = (a - b);

                result = Double.toString(r);

                event.getChannel().sendMessage("**Wynik tego dzialania to:** " + result).queue();
            }
            else if(message[1].equalsIgnoreCase("pomnóż"))
            {
                double a,b,r;
                String result;
                a = Double.parseDouble(message[2]);
                b = Double.parseDouble(message[3]);
                r = (a * b);

                result = Double.toString(r);

                event.getChannel().sendMessage("**Wynik tego dzialania to:** " + result).queue();
            }
            else if(message[1].equalsIgnoreCase("podziel"))
            {
                if(message[3] == "0")
                {
                    return;
                }
                double a,b,r;
                String result;
                a = Double.parseDouble(message[2]);
                b = Double.parseDouble(message[3]);
                r = (a / b);

                result = Double.toString(r);

                event.getChannel().sendMessage("**Wynik tego dzialania to:** " + result).queue();
            }
        }

    }
}
