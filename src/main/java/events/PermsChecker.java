package events;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PermsChecker extends ListenerAdapter
{
    public static String adminsId[] = new String[10];

    public static String[] getPerms(GuildMessageReceivedEvent event)
    {

        int licznik = 0;
        File plik = new File("ownerid.txt");
        try
        {
            Scanner odczyt = new Scanner(plik);

                while (odczyt.hasNextLine()) {
                    try {
                        adminsId[licznik] = odczyt.nextLine();
                        licznik++;
                    } catch (Exception e) {
                        System.out.println("Błąd!");
                    }
                }

        }
        catch(FileNotFoundException except)
        {
            System.out.println("Nie udało się znaleźć pliku 'ownerid.txt'!");
        }


        return adminsId;

    }
}
