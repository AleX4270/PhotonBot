
import bot.status.BotStatus;
import events.*;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter
{
    private String pref = "?";
    private static String token = "NTM4NDU1NjY0MzUyMDM0ODI3.Dy0ENQ.BvPgsh9OvZBB-ExJRlL4IuxsuGY"; //dodawanie tokenu bota

    public static void main(String[] args) throws LoginException
    {
        JDA bot = new JDABuilder(token).build();
        bot.addEventListener(new BotEvents()); //dodawanie listenera do nasluchiwania eventow
        bot.addEventListener(new BotStatus());
        bot.addEventListener(new HelloCommand());
        bot.addEventListener(new HelpCommand());
        bot.addEventListener(new VersionCommand());
        bot.addEventListener(new PingCommand());
        bot.addEventListener(new CalculateCommand());

    }

    /*if((event.getMessage().getContentRaw().startsWith(prefix)))
    {
        String command = event.getMessage().getContentRaw().replace(prefix, "");
        if(command.toLowerCase().contains("say"))
        {
            if(command.replaceAll("(?i)say ", "") != null || command.replaceAll("(?i)say ", "") != " ")
                event.getChannel().sendMessage(command.replaceAll("(?i)say ", "")).queue();
            event.getMessage().delete().queue();
        }*/


}
