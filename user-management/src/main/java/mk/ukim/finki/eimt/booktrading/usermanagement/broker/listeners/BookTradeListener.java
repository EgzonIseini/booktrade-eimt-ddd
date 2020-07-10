package mk.ukim.finki.eimt.booktrading.usermanagement.broker.listeners;

import mk.ukim.finki.eimt.booktrading.sharedkernel.SharedConfiguration;
import mk.ukim.finki.eimt.booktrading.usermanagement.UserManagementApplication;
import mk.ukim.finki.eimt.booktrading.usermanagement.application.UserApplicationService;
import mk.ukim.finki.eimt.booktrading.usermanagement.integration.BookTradeAcceptedRabbitMqEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookTradeListener {

    private static final Logger log = LoggerFactory.getLogger(BookTradeListener.class);

    private final UserApplicationService userApplicationService;

    public BookTradeListener(UserApplicationService userApplicationService) {
        this.userApplicationService = userApplicationService;
    }

    @RabbitListener(queues = SharedConfiguration.BOOKS_QUEUE)
    public void receiveBookTradeAcceptedEvent(BookTradeAcceptedRabbitMqEvent bookTradeAcceptedRabbitMqEvent) {
        log.info("Received RabbitMQ message is: {}", bookTradeAcceptedRabbitMqEvent.toString());
        userApplicationService.onBookTradeAccepted(bookTradeAcceptedRabbitMqEvent);
    }
}
