package edu.wgu.d387_sample_code.i18n;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class GreetingsController {

    @GetMapping("/welcome")
    public ResponseEntity<String> displayWelcome (@RequestParam("lang") String lang) {
        Locale locale = Locale.forLanguageTag(lang);
        GreetingsMessage welcomeMessage = new GreetingsMessage(locale);
        return new ResponseEntity<String> (welcomeMessage.getWelcomeMessage(), HttpStatus.OK); // Response
    }
}
