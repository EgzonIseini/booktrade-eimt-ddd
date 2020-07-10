package mk.ukim.finki.eimt.booktrading.booktrade.application;

import mk.ukim.finki.eimt.booktrading.booktrade.domain.model.BookTrade;
import mk.ukim.finki.eimt.booktrading.booktrade.domain.model.BookTradeOfferId;
import mk.ukim.finki.eimt.booktrading.booktrade.repository.BookTradeOfferRepository;
import mk.ukim.finki.eimt.booktrading.booktrade.repository.BookTradeRepository;
import org.springframework.stereotype.Service;

@Service
public class BookTradeApplicationService {

    private final BookTradeRepository bookTradeRepository;
    private final BookTradeOfferRepository bookTradeOfferRepository;

    public BookTradeApplicationService(
            BookTradeRepository bookTradeRepository,
            BookTradeOfferRepository bookTradeOfferRepository
    ) {
        this.bookTradeRepository = bookTradeRepository;
        this.bookTradeOfferRepository = bookTradeOfferRepository;
    }

    public BookTrade createBookTrade(BookTradeOfferId id) {
        var bookTradeOffer = bookTradeOfferRepository.findById(id).orElseThrow(RuntimeException::new);
        var bookTrade = BookTrade.valueOf(bookTradeOffer);

        // RABBIT MQ LOGIC TO CHANGE BOOK AVAILABILITY

        return bookTradeRepository.save(bookTrade);
    }

}
