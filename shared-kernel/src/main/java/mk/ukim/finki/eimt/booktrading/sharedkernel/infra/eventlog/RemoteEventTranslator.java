package mk.ukim.finki.eimt.booktrading.sharedkernel.infra.eventlog;

import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.DomainEvent;

import java.util.Optional;

public interface RemoteEventTranslator {

    boolean supports(StoredDomainEvent storedDomainEvent);

    Optional<DomainEvent> translate(StoredDomainEvent remoteEvent);
}
