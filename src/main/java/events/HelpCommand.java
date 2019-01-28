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
            help.addField("?helpo", "Wyświetla komendy dostępne tylko dla administracji bota,", false);
            help.addField("?say :ab:", "Sprawia, że bot napisze co zechcesz :)",false);
            help.addField("?invite :space_invader:", "Tworzy link z zaproszeniem na serwer.", false);
            event.getChannel().sendMessage(help.build()).queue();
    }

    public static void ShowOHelp(GuildMessageReceivedEvent event)
    {
            EmbedBuilder helpo= new EmbedBuilder();
            helpo.setTitle("Komendy administracji:", null);
            helpo.setColor(Color.RED);
            helpo.setDescription("Lista komend dostępnych tylko dla administracji!");
            helpo.addField("?status", "Wpisz ?status /status/, zby zmienic aktualny status bota!", false);
            event.getChannel().sendMessage(helpo.build()).queue();

    }
}
