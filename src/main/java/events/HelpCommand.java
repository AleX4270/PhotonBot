package events;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class HelpCommand extends ListenerAdapter
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

        if(messageSent.equalsIgnoreCase(pref + "help"))
        {
            EmbedBuilder help = new EmbedBuilder();
            help.setTitle("Dostepne komendy: ", null);
            help.setColor(Color.MAGENTA);
            help.setDescription("Komendy dostepne do uzycia w aktualnej wersji bota.");
            help.addField("?witaj :raised_hands: " , "Sprawia, ze bot sie z toba przywita.", false);
            help.addField("?ping :ping_pong:" , "Wyswietla aktualny ping bota.", false);
            help.addField("?moszka", "Kilka ciekawostek o Hubercie",false);
            help.addField("?version :wrench:","Pokazuje informacje techniczne na temat bota", false);
            event.getChannel().sendMessage(help.build()).queue();

        }




    }
}
