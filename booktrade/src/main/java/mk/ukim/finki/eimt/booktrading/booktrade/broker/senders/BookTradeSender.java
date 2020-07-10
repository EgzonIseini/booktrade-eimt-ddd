package mk.ukim.finki.eimt.booktrading.booktrade.broker.senders;

import mk.ukim.finki.eimt.booktrading.booktrade.domain.event.BookTradeAccepted;
import mk.ukim.finki.eimt.booktrading.sharedkernel.SharedConfiguration;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookTradeSender {

    private final RabbitTemplate rabbitTemplate;

    public BookTradeSender(
            RabbitTemplate rabbitTemplate
    ) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendBookTradeAcceptedMessage(BookTradeAccepted bookTradeAccepted) {
        rabbitTemplate.convertAndSend(SharedConfiguration.EXCHANGE_NAME, SharedConfiguration.BOOKS_QUEUE, bookTradeAccepted);
    }

}
