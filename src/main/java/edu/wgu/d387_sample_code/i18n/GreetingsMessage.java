package edu.wgu.d387_sample_code.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class GreetingsMessage implements Runnable {

    private Locale locale;

    // Constructor
    public GreetingsMessage(Locale locale) {
        this.locale = locale;
    }

    public String getWelcomeMessage() {
        ResourceBundle bundle = ResourceBundle.getBundle("language",locale);
        return bundle.getString("welcome");
    }

    @Override
    public void run() {
        System.out.println( getWelcomeMessage() + " FROM ThreadID: " + Thread.currentThread().getId() );
    }
}
