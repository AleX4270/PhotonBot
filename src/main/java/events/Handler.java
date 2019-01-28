package events;

import bot.status.BotStatus;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Handler extends ListenerAdapter
{
    private String pref = "?";
    public String status;
    private String ownerId = "";


    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event)
    {
        String messageSent = event.getMessage().getContentRaw();
        String channelName = event.getChannel().getName();
        String messageAuthor = event.getAuthor().getName();
        String authorName = event.getMember().getUser().getName();
        String serverName = event.getGuild().getName();
        String authorId = event.getAuthor().getId();

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
        else if(messageSent.equalsIgnoreCase(pref + "help")) //komenda help
        {
            HelpCommand.Show(event);
        }
        else if(messageSent.equalsIgnoreCase(pref + "wersja"))  //komenda wersja
        {
            VersionCommand.Show(event);
        }


        if (message[0].equalsIgnoreCase(pref + "status"))
        {
            //ownerId = PermsChecker.getPerms(event);
            ownerId = "278953882628128769";
            System.out.println("ID1: " + authorId);
            System.out.println("ID2: " + ownerId);
            if(authorId == ownerId)
            {

                status = StatusCommand.Change(event, message);
                //System.out.println(status);
                BotStatus.changedStatus = status;
                BotStatus.Status(event);
            }
            else if(authorId != ownerId)
            {
                System.out.println(authorName + " chcial zmienic status bota bez odpowiednich permisji!");
                event.getChannel().sendMessage("**Nie posiadasz odpowiednich uprawnień, żeby użyć tej komendy!**").queue();

                return;
            }
        }



    }


    @Override
    public void onReady(ReadyEvent event)
    {
        BotStatus.ChangeDefault(event);
    }
}
