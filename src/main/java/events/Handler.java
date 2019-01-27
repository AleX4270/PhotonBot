package events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Handler extends ListenerAdapter
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

        System.out.println("Wiadomosc na serwerze: " + serverName + " na kanale: "
                + channelName + " od " + authorName + ": " + messageSent);
        //wiadomosc do konsoli o tym kto i co wyslal, w skrocie logi

        String message[] = event.getMessage().getContentRaw().split(" ");

        if(event.getAuthor().isBot()) //jezeli wiadomosc napisal bot to nie wypisuj
        {
            return;
        }

        if(messageSent.equalsIgnoreCase(pref + "witaj")) //komenda witaj
        {
            HelloCommand.Show(event);
        }
        else if(message[0].equalsIgnoreCase(pref + "kalkulator")) //glowna czesc komendy
        {
            try
            {
                CalculateCommand.Show(event, message);
            }
            catch(Exception e)
            {
                event.getChannel().sendMessage("**Wystąpił błąd!**").queue(); //jezeli nie powiedzie się dodawanie
            }
        }
        else if(messageSent.equalsIgnoreCase(pref + "ping")) //komenda ping
        {
            PingCommand.Show(event);
        }
        else if(messageSent.equalsIgnoreCase(pref + "help"))
        {
            HelpCommand.Show(event);
        }
        else if(messageSent.equalsIgnoreCase(pref + "wersja"))
        {
            VersionCommand.Show(event);
        }
    }
}
