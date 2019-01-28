package events;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PermsChecker extends ListenerAdapter
{
    public static String getPerms(GuildMessageReceivedEvent event)
    {
        String ownerId = "";
        File plik = new File("ownerid.txt");
        try
        {
            Scanner odczyt = new Scanner(plik);
            while(odczyt.hasNextLine())
            {
                ownerId = odczyt.toString();
            }
        }
        catch(FileNotFoundException except)
        {
            System.out.println("Nie udało się znaleźć pliku 'ownerid.txt'!");
        }


        return ownerId;
    }
}
