package mk.ukim.finki.eimt.booktrading.booktrade.controller;


import mk.ukim.finki.eimt.booktrading.booktrade.application.BookTradeApplicationService;
import mk.ukim.finki.eimt.booktrading.booktrade.application.TradeOfferApplicationService;
import mk.ukim.finki.eimt.booktrading.booktrade.domain.model.BookTrade;
import mk.ukim.finki.eimt.booktrading.booktrade.domain.model.BookTradeOffer;
import mk.ukim.finki.eimt.booktrading.booktrade.domain.model.BookTradeOfferId;
import mk.ukim.finki.eimt.booktrading.booktrade.domain.model.UserId;
import mk.ukim.finki.eimt.booktrading.booktrade.domain.model.dto.BookTradeOfferRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book-trade-offer")
public class BookTradeOfferController {

    private final TradeOfferApplicationService tradeOfferApplicationService;
    private final BookTradeApplicationService bookTradeApplicationService;

    public BookTradeOfferController(
            TradeOfferApplicationService tradeOfferApplicationService,
            BookTradeApplicationService bookTradeApplicationService
    ) {
        this.tradeOfferApplicationService = tradeOfferApplicationService;
        this.bookTradeApplicationService = bookTradeApplicationService;
    }

    @GetMapping
    public List<BookTradeOffer> getAllBookTradeOffers() {
        return this.tradeOfferApplicationService.getAllBookTradeOffers();
    }

    @PostMapping
    public BookTradeOffer createNewBookTradeOffer(@RequestBody BookTradeOfferRequestDto bookTradeOfferRequestDto) {
        return tradeOfferApplicationService.createNewBookTradeOffer(bookTradeOfferRequestDto);
    }

    @GetMapping("/users/{userId}/offers")
    public List<BookTradeOffer> getAllBookOffersForUserId(@PathVariable String userId) {
        return tradeOfferApplicationService.getAllBookTradeOffersForUserId(new UserId(userId));
    }

    @PatchMapping("/{oldOfferId}/counter-offer")
    public BookTradeOffer counterOffer(@PathVariable String oldOfferId, @RequestBody BookTradeOfferRequestDto bookTradeOfferRequestDto) {
        return tradeOfferApplicationService.counterOffer(new BookTradeOfferId(oldOfferId), bookTradeOfferRequestDto);
    }

    @PostMapping("/{bookTradeOfferId}/accept")
    public BookTrade acceptBookTradeOffer(@PathVariable String bookTradeOfferId) {
        return bookTradeApplicationService.createBookTrade(new BookTradeOfferId(bookTradeOfferId));
    }
}
