package oed_bot;

import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.objects.Locality;
import org.telegram.abilitybots.api.objects.Privacy;
import org.telegram.telegrambots.bots.DefaultBotOptions;

public class HelloBot extends AbilityBot {
	
	protected HelloBot(String botToken, String botUsername, DefaultBotOptions botOptions) {
		super(BOT_TOKEN, BOT_USERNAME, botOptions);
		// TODO Auto-generated constructor stub
	}
	
	protected HelloBot() {
		super(BOT_TOKEN, BOT_USERNAME);
	}

	public static String BOT_TOKEN = "835877738:AAH9R1gE3vTK2YwqL-CDy6SCeWi8QkvQ1Kg";
	public static String BOT_USERNAME = "hotusm";

	
	@Override
	public int creatorId() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public Ability sayHelloWorld() {
	    return Ability
	              .builder()
	              .name("hello")
	              .info("says hello world!")
	              .locality(Locality.ALL)
	              .privacy(Privacy.PUBLIC)
	              .action(ctx -> silent.send("Hello world!", ctx.chatId()))
	              .build();
	}

}
