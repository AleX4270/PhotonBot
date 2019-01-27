package events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import sun.applet.Main;

public class BotEvents extends ListenerAdapter
{
    private String pref = "?";

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) //eventy po otrzymaniu danej wiadomosci
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

        System.out.println("Wiadomosc na serwerze: " + serverName + " na kanale: "
                + channelName + " od " + authorName + ": " + messageSent);
                 //wiadomosc do konsoli o tym kto i co wyslal, w skrocie logi




        if(messageSent.equalsIgnoreCase(pref + "moszka")) //informacje o hubercie :)
        {
            event.getChannel().sendMessage("__**Ta komenda jest obecnie dezaktywowana ze wzgledu na problemy " +
                    "z obsluga jezyka polskiego!**__ ").queue();
        }

        }





    }


