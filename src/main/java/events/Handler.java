package events;

import bot.status.BotStatus;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Handler extends ListenerAdapter
{
    private String pref = "?";
    public static String status;
    private String ownerId = "";
    public static String language = "Polish"; //domyslny jezyk polski


    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event)
    {
        String messageSent = event.getMessage().getContentRaw();
        String channelName = event.getChannel().getName();
        String messageAuthor = event.getAuthor().getName();
        String authorName = event.getMember().getUser().getName();
        String serverName = event.getGuild().getName();
        String authorId = event.getAuthor().getId();

        //System.out.println(messageSent);

        //List mentionedId = event.getMessage().getMentionedUsers();

        //event.getMessage().getMentionedUsers();

        /*for(Object i: mentionedId)
        {
            System.out.println("Zawartosc listy mentionedId: " + mentionedId);
        }*/

        //String admList[] = PermsChecker.getPerms(event);

        System.out.println("Wiadomosc na serwerze: " + serverName + " na kanale: "
                + channelName + " od " + authorName + ": " + messageSent);
        //wiadomosc do konsoli o tym kto i co wyslal, w skrocie logi


        String message[] = event.getMessage().getContentRaw().split(" ");



        if(event.getAuthor().isBot()) //jezeli wiadomosc napisal bot to nie wypisuj
        {
            return;
        }

        if((messageSent.equalsIgnoreCase(pref + "witaj") && language.equalsIgnoreCase("Polish")) || (messageSent.equalsIgnoreCase(pref + "hello") && language.equalsIgnoreCase("English"))) //komenda witaj
        {
            if(language.equalsIgnoreCase("English"))
            {
                HelloCommand.ShowEng(event);
            }
            else
            {
                HelloCommand.ShowPl(event);
            }
        }
        /*else if((message[0].equalsIgnoreCase(pref + "kalkulator") && language.equalsIgnoreCase("Polish")) || (messageSent.equalsIgnoreCase(pref + "calc") && language.equalsIgnoreCase("English"))) //glowna czesc komendy kalkulator
        {
            try
            {
                CalculateCommand.Show(event, message);
            }
            catch(Exception e)
            {
                if(language.equalsIgnoreCase("Polish"))
                {
                    event.getChannel().sendMessage("**Wystąpił błąd!**").queue(); //jezeli nie powiedzie się dodawanie
                }
                else
                {
                    event.getChannel().sendMessage("**An error occured!**").queue(); //jezeli nie powiedzie się dodawanie
                }

            }
        }*/
        else if(messageSent.equalsIgnoreCase(pref + "ping")) //komenda ping
        {
            if(language.equalsIgnoreCase("English"))
            {
                PingCommand.ShowEng(event);
            }
            else
            {
                PingCommand.ShowPl(event);
            }
        }
        else if((messageSent.equalsIgnoreCase(pref + "pomoc") && language.equalsIgnoreCase("Polish")) || (messageSent.equalsIgnoreCase(pref + "help") && language.equalsIgnoreCase("English")))
        {
            if(language.equalsIgnoreCase("English"))
            {
                HelpCommand.ShowEng(event);
            }
            else
            {
                HelpCommand.ShowPl(event);
            }
        }
        else if(messageSent.equalsIgnoreCase(pref + "helpo"))
        {

            if(checkPermissions(event,PermsChecker.getPerms(event),authorId) == true)
            {
                if(language.equalsIgnoreCase("English"))
                {
                    HelpCommand.ShowOHelpEng(event);
                }
                else
                {
                    HelpCommand.ShowOHelpPl(event);
                }
            }
            else
            {
                if(language.equalsIgnoreCase("Polish"))
                {
                    event.getChannel().sendMessage("**Aj, aj, chyba nie jesteś z administracji ;)**").queue();
                }
                else
                {
                    event.getChannel().sendMessage("**Permissions Denied!**").queue();
                }

            }
        }
        else if((messageSent.equalsIgnoreCase(pref + "shutdown") && language.equalsIgnoreCase("English")) || (messageSent.equalsIgnoreCase(pref + "wylacz") && language.equalsIgnoreCase("Polish")))
        {
            if(checkPermissions(event, PermsChecker.getPerms(event), authorId) == true)
            {
                ShdCommand.Shutdown(event);
            }
            else
            {
                event.getChannel().sendMessage("**Aj, aj, chyba nie jesteś z administracji ;)**").queue();
            }
        }
        else if((messageSent.equalsIgnoreCase(pref + "wersja") && language.equalsIgnoreCase("Polish")) || (messageSent.equalsIgnoreCase(pref + "version") && language.equalsIgnoreCase("English")))  //komenda wersja
        {
            if(language.equalsIgnoreCase("Polish"))
            {
                VersionCommand.ShowPl(event);
            }
            else
            {
                VersionCommand.ShowEng(event);
            }
        }
        else if((message[0].equalsIgnoreCase(pref + "echo") && language.equalsIgnoreCase("Polish")) || (message[0].equalsIgnoreCase(pref + "say") && language.equalsIgnoreCase("English"))) //Komenda say
        {
            SayCommand.Show(event, message);
        }
        else if((message[0].equalsIgnoreCase(pref + "zaproszenie") && language.equalsIgnoreCase("Polish")) || (message[0].equalsIgnoreCase(pref + "invite") && language.equalsIgnoreCase("English"))) //Komenda tworzaca zaproszenie
        {
            InviteCommand.Show(event, message);
        }
        else if(messageSent.equalsIgnoreCase(pref + "smode")) //Komenda wlaczajaca tryb anty spoilerowy
        {
            SpoilMode.Show(event);
        }
        else if(message[0].equalsIgnoreCase(pref + "lang")) //Komenda zmieniajaca jezyk
        {

            if(((message.length < 2 || message.length > 2) && (Handler.language.equals("Polish")))) //Komunikat o wlasciwym uzyciu komendy
            {
                event.getChannel().sendMessage("Uzyj tej komendy poprawnie! **?lang Polish** lub **?lang English**").queue();
                return;
            }
            else if(((message.length < 2 || message.length > 2) && (Handler.language.equals("English")))) //Komunikat o wlasciwym uzyciu komendy
            {
                event.getChannel().sendMessage("Use that command properly. Type **?lang Polish** or **?lang English**").queue();
                return;
            }

            //Komunikaty wyswietlajace sie jezeli probujesz zmienic na jezyk ktory jest juz ustawiony:

            if(message[1].equalsIgnoreCase("Polish") && Handler.language.equals("Polish"))
            {
                event.getChannel().sendMessage("**Ten jezyk jest juz ustawiony! Zapomniales?**").queue();
                return;
            }
            else if(message[1].equalsIgnoreCase("English") && Handler.language.equals("English"))
            {
                event.getChannel().sendMessage("**This language is already set. Did you forget?**").queue();
                return;
            }
            try
            {
                if(message[1].equalsIgnoreCase("polish")) //Komunikat zmiany na jezyk polski
                {
                    Handler.language = "Polish";
                    event.getChannel().sendMessage("**Zmieniono jezyk na polski!**").queue();
                }
                else if(message[1].equalsIgnoreCase("english")) //Komunikat zmiany na jezyk angielski
                {
                    Handler.language = "English";
                    event.getChannel().sendMessage("**The Language has been changed to English!**").queue();
                }
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Wystapil blad podczas zmiany jezyka. [Indeks tablicy poza zasiegiem...]"); //Blad tablicy
            }

        }
        else if (message[0].equalsIgnoreCase(pref + "status"))
        {


            if(checkPermissions(event,PermsChecker.getPerms(event),authorId) == true)
            {

                status = StatusCommand.Change(event, message);
                //System.out.println(status);
                BotStatus.changedStatus = status;
                BotStatus.Status(event);
                if(language.equalsIgnoreCase("Polish"))
                {
                    event.getChannel().sendMessage("**Zmieniono status bota!**").queue();
                }
                else
                {
                    event.getChannel().sendMessage("**Bot status has been changed!**").queue();
                }
            }
            else
            {
                System.out.println(authorName + " chcial zmienic status bota bez odpowiednich permisji!");
                if(language.equalsIgnoreCase("Polish"))
                {
                    event.getChannel().sendMessage("**Nie posiadasz odpowiednich uprawnień, żeby użyć tej komendy!**").queue();
                }
                else
                {
                    event.getChannel().sendMessage("**Permissions Denied!**").queue();
                }


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
