package mk.ukim.finki.eimt.booktrading.usermanagement.integration;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.eimt.booktrading.usermanagement.domain.model.BookId;

import java.io.Serializable;
import java.util.Objects;

@Getter
public class BookTradeAcceptedRabbitMqEvent implements Serializable {

    @JsonProperty("firstPartyBookId")
    private final BookId firstPartyBookId;

    @JsonProperty("secondPartyBookId")
    private final BookId secondPartyBookId;

    public BookTradeAcceptedRabbitMqEvent(
            @JsonProperty("firstPartyBookId") @NonNull BookId firstPartyBookId,
            @JsonProperty("secondPartyBookId") @NonNull BookId secondPartyBookId
    ) {
        this.firstPartyBookId = Objects.requireNonNull(firstPartyBookId, "Book ID of the first party cannot be null.");
        this.secondPartyBookId = Objects.requireNonNull(secondPartyBookId, "Book ID of the second party cannot be null.");
    }

    @Override
    public String toString() {
        return "BookTradeAccepted{" +
                "firstPartyBookId=" + firstPartyBookId.getId() +
                ", secondPartyBookId=" + secondPartyBookId.getId() +
                '}';
    }
}
