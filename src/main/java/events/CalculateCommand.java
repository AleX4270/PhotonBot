package events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class CalculateCommand extends ListenerAdapter
{
    private static String pref = "?";


    public static void Show(GuildMessageReceivedEvent event, String msg[])
    {

            if(msg.length > 4)
            {
                event.getChannel().sendMessage("**Maksymalnie możesz wykonać działanie tylko na 2 liczbach!**").queue();
                return;
            }
            else if(msg[1].equalsIgnoreCase("dodaj")) //dodawanie dwoch liczb
            {
                double a,b,r;
                String result;
                a = Double.parseDouble(msg[2]);
                b = Double.parseDouble(msg[3]);
                r = (a + b);

                result = Double.toString(r);

                event.getChannel().sendMessage("**Wynik tego dzialania to:** " + result).queue();

            }
            else if(msg[1].equalsIgnoreCase("odejmij"))
            {
                double a,b,r;
                String result;
                a = Double.parseDouble(msg[2]);
                b = Double.parseDouble(msg[3]);
                r = (a - b);

                result = Double.toString(r);

                event.getChannel().sendMessage("**Wynik tego dzialania to:** " + result).queue();
            }
            else if(msg[1].equalsIgnoreCase("pomnóż"))
            {
                double a,b,r;
                String result;
                a = Double.parseDouble(msg[2]);
                b = Double.parseDouble(msg[3]);
                r = (a * b);

                result = Double.toString(r);

                event.getChannel().sendMessage("**Wynik tego dzialania to:** " + result).queue();
            }
            else if(msg[1].equalsIgnoreCase("podziel"))
            {

                double a,b,r;
                String result;
                a = Double.parseDouble(msg[2]);
                b = Double.parseDouble(msg[3]);
                if(b == 0)
                {
                    return;
                }
                r = (a / b);

                result = Double.toString(r);

                event.getChannel().sendMessage("**Wynik tego dzialania to:** " + result).queue();
            }
        }

    }

