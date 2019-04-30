package events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class CalculateCommand extends ListenerAdapter
{


    public static void Show(GuildMessageReceivedEvent event, String msg[])
    {

            if(msg.length > 4)
            {
                if(Handler.language.equalsIgnoreCase("Polish"))
                {
                    event.getChannel().sendMessage("**Maksymalnie możesz wykonać działanie tylko na 2 liczbach!**").queue();
                }
                else
                {
                    event.getChannel().sendMessage("**Max 2 numbers!**").queue();
                }

                return;
            }
            else if(msg[1].equalsIgnoreCase("dodaj") || (msg[1].equalsIgnoreCase("add") && Handler.language.equalsIgnoreCase("English"))) //dodawanie dwoch liczb
            {
                double a,b,r;
                String result;
                a = Double.parseDouble(msg[2]);
                b = Double.parseDouble(msg[3]);
                r = (a + b);

                result = Double.toString(r);
                if(Handler.language.equalsIgnoreCase("Polish"))
                {
                    event.getChannel().sendMessage("**Wynik tego dzialania to:** " + result).queue();
                }
                else
                {
                    event.getChannel().sendMessage("**The Result:** " + result).queue();
                }


            }
            else if(msg[1].equalsIgnoreCase("odejmij") || (msg[1].equalsIgnoreCase("subtract") && Handler.language.equalsIgnoreCase("English")))
            {
                double a,b,r;
                String result;
                a = Double.parseDouble(msg[2]);
                b = Double.parseDouble(msg[3]);
                r = (a - b);

                result = Double.toString(r);

                if(Handler.language.equalsIgnoreCase("Polish"))
                {
                    event.getChannel().sendMessage("**Wynik tego dzialania to:** " + result).queue();
                }
                else
                {
                    event.getChannel().sendMessage("**The Result:** " + result).queue();
                }
            }
            else if(msg[1].equalsIgnoreCase("pomnóż") || (msg[1].equalsIgnoreCase("multiply") && Handler.language.equalsIgnoreCase("English")))
            {
                double a,b,r;
                String result;
                a = Double.parseDouble(msg[2]);
                b = Double.parseDouble(msg[3]);
                r = (a * b);

                result = Double.toString(r);

                if(Handler.language.equalsIgnoreCase("Polish"))
                {
                    event.getChannel().sendMessage("**Wynik tego dzialania to:** " + result).queue();
                }
                else
                {
                    event.getChannel().sendMessage("**The Result:** " + result).queue();
                }
            }
            else if(msg[1].equalsIgnoreCase("podziel") || (msg[1].equalsIgnoreCase("divide") && Handler.language.equalsIgnoreCase("English")))
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

                if(Handler.language.equalsIgnoreCase("Polish"))
                {
                    event.getChannel().sendMessage("**Wynik tego dzialania to:** " + result).queue();
                }
                else
                {
                    event.getChannel().sendMessage("**The Result:** " + result).queue();
                }
            }
        }

    }

