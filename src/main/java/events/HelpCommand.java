package events;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HelpCommand extends ListenerAdapter
{

    public static void ShowPl(GuildMessageReceivedEvent event)
    {
            EmbedBuilder help = new EmbedBuilder();
            help.setTitle("Dostępne komendy:", null);
            help.setColor(Color.RED);
            help.setDescription("Komendy dostępne do użycia w aktualnej wersji bota:");
            help.addField("?witaj" + ":raised_hands: " , "Sprawia, że bot się z tobą przywita!", false);
            help.addField("?ping" + ":ping_pong:" , "Pokazuje ping bota.", false);
            help.addField("?wersja :wrench:","Pokazuje informacje techniczne na temat bota", false);
            //help.addField("?kalkulator :heavy_plus_sign:", "dodaj/odejmij/pomnóż/podziel, maksymalnie 2 liczby!", false);
            help.addField("?helpo", "Wyświetla komendy dostępne tylko dla administracji bota,", false);
            help.addField("?echo :ab:", "Sprawia, że bot napisze co zechcesz :)",false);
            help.addField("?zaproszenie :space_invader:", "Tworzy link z zaproszeniem na serwer.", false);
            help.addField("?lang", "Możesz zmienić język bota.", false);
            event.getChannel().sendMessage(help.build()).queue();
    }

    public static void ShowEng(GuildMessageReceivedEvent event)
    {
        EmbedBuilder help = new EmbedBuilder();
        help.setTitle("Available commands:", null);
        help.setColor(Color.RED);
        help.setDescription("Commands available for use in the current version of the bot:");
        help.addField("?hello" + ":raised_hands: " , "It makes the bot will say hello to you!", false);
        help.addField("?ping" + ":ping_pong:" , "It displays the ping.", false);
        help.addField("?version :wrench:","It shows you a piece of tech-info about the bot.", false);
        //help.addField("?calc :heavy_plus_sign:", "You can calculate something simple!", false);
        help.addField("?helpo", "It displays commands available only for the administration of the bot.", false);
        help.addField("?say  :ab:", "It makes the bot will say something that you want :)",false);
        help.addField("?invite :space_invader:", "It creates an invite for a discord server.", false);
        help.addField("?lang", "You can change the language of the bot.", false);
        event.getChannel().sendMessage(help.build()).queue();
    }

    public static void ShowOHelpPl(GuildMessageReceivedEvent event)
    {
            EmbedBuilder helpo= new EmbedBuilder();
            helpo.setTitle("Komendy administracji:", null);
            helpo.setColor(Color.RED);
            helpo.setDescription("Lista komend dostępnych tylko dla administracji!");
            helpo.addField("?status", "Wpisz ?status /status/, zby zmienic aktualny status bota!", false);
            helpo.addField("?shutdown", "Wylacza bota!", false);
            event.getChannel().sendMessage(helpo.build()).queue();

    }

    public static void ShowOHelpEng(GuildMessageReceivedEvent event)
    {
        EmbedBuilder helpo= new EmbedBuilder();
        helpo.setTitle("Administration Commands:", null);
        helpo.setColor(Color.RED);
        helpo.setDescription("The list of commands which can be used only by administration of the bot!");
        helpo.addField("?status", "Type ?status /status/ to change the actual status of the bot!", false);
        helpo.addField("?shutdown", "It turns off the bot!", false);
        event.getChannel().sendMessage(helpo.build()).queue();

    }
}
