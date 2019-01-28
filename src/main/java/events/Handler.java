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

        //String admList[] = PermsChecker.getPerms(event);

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

        if(messageSent.equalsIgnoreCase(pref + "helpo"))
        {

            if(checkPermissions(event,PermsChecker.getPerms(event),authorId) == true)
            {
                HelpCommand.ShowOHelp(event);
            }
            else
            {
                event.getChannel().sendMessage("**Aj, aj, chyba nie jesteś z administracji ;)**").queue();
            }
        }

        if(messageSent.equalsIgnoreCase(pref + "wersja"))  //komenda wersja
        {
            VersionCommand.Show(event);
        }
        else if(message[0].equalsIgnoreCase(pref + "say"))
        {
            SayCommand.Show(event, message);
        }
        else if(message[0].equalsIgnoreCase(pref + "invite"))
        {
            InviteCommand.Show(event, message);
        }


        if (message[0].equalsIgnoreCase(pref + "status"))
        {


            if(checkPermissions(event,PermsChecker.getPerms(event),authorId) == true)
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

    public boolean checkPermissions(GuildMessageReceivedEvent evnt, String adminList[], String aId)
    {
        for(int i = 0; i < adminList.length; i++)
        {
            if(aId.equals(adminList[i]))
            {
                return true;
            }
            else
            {
                continue;
            }
        }

        return false;
    }
}
