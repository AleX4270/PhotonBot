
import bot.status.BotStatus;
import events.*;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter
{
    public static void main(String[] args) throws LoginException
    {
        String token = "NTcwNTc5MjAxMDE5NjA5MTE0.XMBQfg.wWOIrRB07N4Ok9N9UqEl2UVgldo";

        JDA bot = new JDABuilder(token).build();

        System.out.println("Liczba dodanych administratorow: " + (PermsChecker.licznik + 1) + " czyli ja xD");

        bot.addEventListener(new Handler());

    }




}
//NTcwNTc5MjAxMDE5NjA5MTE0.XMBQfg.wWOIrRB07N4Ok9N9UqEl2UVgldo

//NTM4NDU1NjY0MzUyMDM0ODI3.Dy0ENQ.BvPgsh9OvZBB-ExJRlL4IuxsuGY stare