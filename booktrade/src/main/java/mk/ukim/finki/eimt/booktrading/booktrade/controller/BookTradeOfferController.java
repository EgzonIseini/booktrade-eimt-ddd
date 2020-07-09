package mk.ukim.finki.eimt.booktrading.booktrade.controller;


import mk.ukim.finki.eimt.booktrading.booktrade.application.TradeOfferApplicationService;
import mk.ukim.finki.eimt.booktrading.booktrade.domain.model.BookTradeOffer;
import mk.ukim.finki.eimt.booktrading.booktrade.domain.model.dto.BookTradeOfferRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book-trade-offer")
public class BookTradeOfferController {

    private final TradeOfferApplicationService tradeOfferApplicationService;

    public BookTradeOfferController(
            TradeOfferApplicationService tradeOfferApplicationService
    ) {
        this.tradeOfferApplicationService = tradeOfferApplicationService;
    }

    @PostMapping
    public BookTradeOffer createNewBookTradeOffer(@RequestBody BookTradeOfferRequestDto bookTradeOfferRequestDto) {
        return tradeOfferApplicationService.createNewBookTradeOffer(bookTradeOfferRequestDto);
    }

}
