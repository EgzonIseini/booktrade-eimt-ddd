package mk.ukim.finki.eimt.booktrading.booktrade.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Data
public class BookTradeOfferRequestDto {

    @JsonProperty("first_party")
    private final String firstParty;

    @JsonProperty("second_party")
    private final String secondParty;

    @JsonProperty("offered_book")
    private final String offeredBook;

    @JsonProperty("requested_book")
    private final String requestedBook;

    @JsonProperty("trade_ending_date")
    private final LocalDateTime tradeEndingDate;

}
