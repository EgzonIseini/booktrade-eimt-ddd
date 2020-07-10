package mk.ukim.finki.eimt.booktrading.booktrade.domain.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.eimt.booktrading.booktrade.domain.model.BookId;

import java.io.Serializable;
import java.util.Objects;

@Getter
public class BookTradeAccepted implements Serializable {

    @JsonProperty("firstPartyBookId")
    private final BookId firstPartyBookId;

    @JsonProperty("secondPartyBookId")
    private final BookId secondPartyBookId;

    public BookTradeAccepted(
            @NonNull BookId firstPartyBookId,
            @NonNull BookId secondPartyBookId
    ) {
        this.firstPartyBookId = Objects.requireNonNull(firstPartyBookId, "Book ID of the first party cannot be null.");
        this.secondPartyBookId = Objects.requireNonNull(secondPartyBookId, "Book ID of the second party cannot be null.");
    }

}
