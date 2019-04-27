package oed_bot;

import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.objects.Locality;
import org.telegram.abilitybots.api.objects.Privacy;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class OedBot extends TelegramLongPollingBot {

	public void onUpdateReceived(Update e) {
		Message msg = e.getMessage(); // Это нам понадобится
		String txt = msg.getText();
		System.out.println("Command: [" + txt + "] from [" + msg.getChatId() + "]");
		if (txt.equals("/start")) {
			sendMsg(msg, "Hello, world! This is simple bot!"); 
		}
		
	}

	public String getBotUsername() {
		return "USER";
	}

	@Override
	public String getBotToken() {
		return "";
	}
	
	@SuppressWarnings("deprecation") // Означает то, что в новых версиях метод уберут или заменят
	private void sendMsg(Message msg, String text) {
		SendMessage s = new SendMessage();
		s.setChatId(msg.getChatId()); // Боту может писать не один человек, и поэтому чтобы отправить сообщение, грубо говоря нужно узнать куда его отправлять
		s.setText(text);
		try { //Чтобы не крашнулась программа при вылете Exception 
			execute(s);
		} catch (TelegramApiException e){
			e.printStackTrace();
		}
	}
	

}
