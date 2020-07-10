package mk.ukim.finki.eimt.booktrading.booktrade.application;

import mk.ukim.finki.eimt.booktrading.booktrade.broker.senders.BookTradeSender;
import mk.ukim.finki.eimt.booktrading.booktrade.domain.event.BookTradeAccepted;
import mk.ukim.finki.eimt.booktrading.booktrade.domain.model.BookTrade;
import mk.ukim.finki.eimt.booktrading.booktrade.domain.model.BookTradeOfferId;
import mk.ukim.finki.eimt.booktrading.booktrade.repository.BookTradeOfferRepository;
import mk.ukim.finki.eimt.booktrading.booktrade.repository.BookTradeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BookTradeApplicationService {

    private final BookTradeRepository bookTradeRepository;
    private final BookTradeOfferRepository bookTradeOfferRepository;
    private final BookTradeSender bookTradeSender;

    public BookTradeApplicationService(
            BookTradeRepository bookTradeRepository,
            BookTradeOfferRepository bookTradeOfferRepository,
            BookTradeSender bookTradeSender
    ) {
        this.bookTradeRepository = bookTradeRepository;
        this.bookTradeOfferRepository = bookTradeOfferRepository;
        this.bookTradeSender = bookTradeSender;
    }

    public BookTrade createBookTrade(BookTradeOfferId id) {
        var bookTradeOffer = bookTradeOfferRepository.findById(id).orElseThrow(RuntimeException::new);
        var bookTrade = BookTrade.valueOf(bookTradeOffer);

        bookTradeSender.sendBookTradeAcceptedMessage(new BookTradeAccepted(bookTrade.getFirstPartyBookId(), bookTrade.getSecondPartyBookId()));
        return bookTradeRepository.save(bookTrade);
    }

}
