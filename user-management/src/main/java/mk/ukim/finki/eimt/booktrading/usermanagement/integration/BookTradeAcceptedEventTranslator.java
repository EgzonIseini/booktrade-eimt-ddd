package mk.ukim.finki.eimt.booktrading.usermanagement.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.DomainEvent;
import mk.ukim.finki.eimt.booktrading.sharedkernel.infra.eventlog.RemoteEventTranslator;
import mk.ukim.finki.eimt.booktrading.sharedkernel.infra.eventlog.StoredDomainEvent;

import java.util.Optional;

public class BookTradeAcceptedEventTranslator implements RemoteEventTranslator {

    private final ObjectMapper objectMapper;

    public BookTradeAcceptedEventTranslator(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean supports(StoredDomainEvent storedDomainEvent) {
        return storedDomainEvent.domainEventClassName().equals("package mk.ukim.finki.eimt.booktrading.usermanagement.integration.BookTradeAcceptedEvent");
    }

    @Override
    public Optional<DomainEvent> translate(StoredDomainEvent remoteEvent) {
        //return Optional.of(remoteEvent.toDomainEvent(objectMapper, BookTradeAcceptedEvent.class));
        return Optional.empty();
    }
}
