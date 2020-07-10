package mk.ukim.finki.eimt.booktrading.sharedkernel.port.client;

import lombok.NonNull;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.RemoteEventLog;
import mk.ukim.finki.eimt.booktrading.sharedkernel.infra.eventlog.RemoteEventLogService;
import mk.ukim.finki.eimt.booktrading.sharedkernel.infra.eventlog.StoredDomainEvent;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

public class RemoteEventLogServiceClient implements RemoteEventLogService {

    private final String source;
    private final String serverUrl;
    private final RestTemplate restTemplate;

    public RemoteEventLogServiceClient(
            @NonNull String serverUrl, int connectionTimeout, int readTimouet
    ) {
        this.source = Objects.requireNonNull(serverUrl, "Server URL cannot be null.");
        this.serverUrl = serverUrl;
        this.restTemplate = new RestTemplate();

        var requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(connectionTimeout);
        this.restTemplate.setRequestFactory(requestFactory);
    }

    @Override
    public String source() { return source; }

    @Override
    public RemoteEventLog currentLog(long lastProcessedId) {
        URI currentLogUri = UriComponentsBuilder.fromUriString(serverUrl)
                .path(String.format("/api/event-log/%d", lastProcessedId)).build().toUri();
        return retrieveLog(currentLogUri);
    }

    @NonNull
    private RemoteEventLog retrieveLog(@NonNull URI uri) {
        ResponseEntity<List<StoredDomainEvent>> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<StoredDomainEvent>>() {});

        if(response.getStatusCode() != HttpStatus.OK) {
            throw new IllegalArgumentException("Could not retrieve log from URI " + uri);
        }

        return new RemoteEventLogImp(response);
    }

    private class RemoteEventLogImp implements RemoteEventLog {

        public RemoteEventLogImp(ResponseEntity<List<StoredDomainEvent>> response) {
        }

        @Override
        public List<StoredDomainEvent> events() {
            return null;
        }
    }
}
