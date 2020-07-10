package mk.ukim.finki.eimt.booktrading.sharedkernel.infra.eventlog;

import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.RemoteEventLog;

public interface RemoteEventLogService {

    String source();

    RemoteEventLog currentLog(long lastProcessedId);

}
