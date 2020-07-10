package mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base;

import mk.ukim.finki.eimt.booktrading.sharedkernel.infra.eventlog.StoredDomainEvent;

import java.util.List;

public interface RemoteEventLog {

    List<StoredDomainEvent> events();
}
