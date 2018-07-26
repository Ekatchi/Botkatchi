package com.github.decyg;


import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.util.*;


import java.util.Random;
import java.util.Scanner;

/**
 * Created by declan on 03/04/2017.
 * Used by Ka, last updated 11/02/2017.
 */
public class MainRunner {

    public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println("Please enter the bots token as the first argument e.g java -jar thisjar.jar tokenhere");
			return;
		}

		IDiscordClient cli = BotUtils.getBuiltDiscordClient(args[0]);

		// Register a listener via the EventSubscriber annotation which allows for organisation and delegation of events
		cli.getDispatcher().registerListener(new CommandHandler());

		// Only login after all events are registered otherwise some may be missed.
		cli.login();
		updateBotPresence(cli);
		Random random = new Random();
		String[] status = {"With 0's and 1's", "With Literal Cancer","Circle Simulator 2017", "100% Salt Juice", "League of Legends: Game of the Year Edition", "the Embodiment of Scarlet Failure", "Degenerate Dredge", "Infernities in 2017", "Tryhardt", "ＦＵＣＣ: The Game", "With Cardboard Stocks", "with the Bloodghast Brigade", "with the Amalgam-nation", "with the Nar-crew-moeba"};
		cli.changePlayingText(status[random.nextInt(14)]);
		Scanner diddleboard = new Scanner(System.in);

		while (true) {
	/*
            150757350976782336 < General chat for clownfiesta
            162014083409772545 < Code_talk for clownfiesta
            318817870962229258 < bot_playground for clownfiesta
            471508288794787862 < #gamimng-gacha on #gaming-gacha
            471509973185200148 < general on #gaming-gacha

*/
			Long channelID = Long.valueOf(diddleboard.nextLine());
			String message = diddleboard.nextLine();
			try {
				new MessageBuilder(cli).withChannel(channelID).withContent(message).build();
				updateBotPresence(cli);
			} catch (DiscordException e) {
				System.err.println("Message could not be sent with error: ");
				e.printStackTrace();
			}

		}
	}


    public static void updateBotPresence(IDiscordClient client)
    {
        Random random = new Random();
        String[] status = {"With 0's and 1's", "With Literal Cancer","Circle Simulator 2017", "100% Salt Juice", "League of Legends: Game of the Year Edition", "the Embodiment of Scarlet Failure", "Degenerate Dredge", "Infernities in 2017", "Tryhardt", "ＦＵＣＣ: The Game", "With Cardboard Stocks", "with the Bloodghast Brigade", "with the Amalgam-nation", "with the Nar-crew-moeba"};
        client.changePlayingText(status[random.nextInt(14)]);
    }
    }

