package mk.ukim.finki.eimt.booktrading.usermanagement.domain.events;

import org.springframework.context.ApplicationEvent;

public class BookTradeAcceptedEvent extends ApplicationEvent {

    public BookTradeAcceptedEvent(Object source) {
        super(source);
    }

}
