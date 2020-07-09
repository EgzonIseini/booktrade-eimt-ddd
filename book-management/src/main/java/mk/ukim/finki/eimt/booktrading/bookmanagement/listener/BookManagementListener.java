package mk.ukim.finki.eimt.booktrading.bookmanagement.listener;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BookManagementListener {

    public void receiveMessage(Map<String, String> message) {
        String id = message.get("id");
        System.out.println("The message is " + message);
    }

}
