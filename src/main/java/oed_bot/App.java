package oed_bot;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.DefaultBotOptions.ProxyType;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class App {
	
	private static String PROXY_HOST = "104.237.253.196" /* proxy host */;
    private static Integer PROXY_PORT = 1080 /* proxy port */;

	public static void main(String[] args) {
		System.out.println("Start bot loading");
		
		

		ApiContextInitializer.init(); // Инициализируем апи

		/*
		 * WORK TelegramBotsApi botapi = new TelegramBotsApi(); try {
		 * botapi.registerBot(new OedBot()); } catch (TelegramApiException e) {
		 * e.printStackTrace(); }
		 */

		// Initializes dependencies necessary for the base bot - Guice
		ApiContextInitializer.init();

		// Create the TelegramBotsApi object to register your bots
		TelegramBotsApi botsApi = new TelegramBotsApi();
		
		DefaultBotOptions botOptions = ApiContext.getInstance(DefaultBotOptions.class); 
		
		botOptions.setProxyHost(PROXY_HOST);
        botOptions.setProxyPort(PROXY_PORT);
        
        botOptions.setProxyType(DefaultBotOptions.ProxyType.SOCKS5);

		try {
			// Register your newly created AbilityBot
			// botsApi.registerBot(new HelloBot());
			botsApi.registerBot(new HelloBot("","",botOptions));
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}

		System.out.println("UP");

	}
}
