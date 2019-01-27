package events;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class HelpCommand extends ListenerAdapter
{



    public static void Show(GuildMessageReceivedEvent event)
    {


            EmbedBuilder help = new EmbedBuilder();
            help.setTitle("Dostepne komendy: ", null);
            help.setColor(Color.MAGENTA);
            help.setDescription("Komendy dostępne do użycia w aktualnej wersji bota.");
            help.addField("?witaj :raised_hands: " , "Sprawia, że bot się z tobą przywita.", false);
            help.addField("?ping :ping_pong:" , "Wyświetla aktualny ping bota.", false);
            help.addField("?wersja :wrench:","Pokazuje informacje techniczne na temat bota", false);
            help.addField("?kalkulator :heavy_plus_sign:", "dodaj/odejmij/pomnóż/podziel, maksymalnie 2 liczby!", false);
            event.getChannel().sendMessage(help.build()).queue();






    }
}