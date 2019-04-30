package events;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PermsChecker extends ListenerAdapter {
    public static String adminsId[] = new String[10];
    public static int licznik = 0;

    public static String[] getPerms(GuildMessageReceivedEvent event)
    {



        File plik = new File("ownerid.txt");
        try {
            Scanner odczyt = new Scanner(plik);

            while (odczyt.hasNextLine()) {
                try {
                     adminsId[licznik] = odczyt.nextLine();
                    licznik++;
                } catch (Exception e) {
                    System.out.println("Błąd!");
                }
            }
            odczyt.close();

        } catch (FileNotFoundException except) {
            System.out.println("Nie udało się znaleźć pliku 'ownerid.txt'!");
        }


        return adminsId;

    }

    public static void AddAdmin(GuildMessageReceivedEvent event, String newAdminID)
    {
        try {
            PrintWriter zapis = new PrintWriter("ownerid.txt");
            zapis.println(newAdminID);
            zapis.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Wystąpił błąd podczas zapisywania nowego admina do pliku!");
        }
    }
}
