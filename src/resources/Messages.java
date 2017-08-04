package resources;

import java.util.Locale;
import java.util.ResourceBundle;

public class Messages {
	private static Messages instance = new Messages();
	private static ResourceBundle messages;

	private Messages() {
		Locale defaultLocale = new Locale("en", "US");
		messages = ResourceBundle.getBundle("MessagesBundle", defaultLocale);
	}

	public static Messages getInstance() {
		if (instance == null) {
			instance = new Messages();
		}
		return instance;
	}

	public static String getMessage(MessageKeys key) {
		return messages.getString(key.toString());
	}
}
