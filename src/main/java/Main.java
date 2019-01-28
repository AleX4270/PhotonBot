
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

    private static String token = "NTM4NDU1NjY0MzUyMDM0ODI3.Dy0ENQ.BvPgsh9OvZBB-ExJRlL4IuxsuGY"; //dodawanie tokenu bota

    public static void main(String[] args) throws LoginException
    {
        JDA bot = new JDABuilder(token).build();


        bot.addEventListener(new Handler());

    }




}
