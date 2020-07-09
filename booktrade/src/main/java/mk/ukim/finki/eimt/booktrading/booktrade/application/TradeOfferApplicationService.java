package mk.ukim.finki.eimt.booktrading.booktrade.application;

import mk.ukim.finki.eimt.booktrading.booktrade.domain.model.BookTradeOffer;
import mk.ukim.finki.eimt.booktrading.booktrade.domain.model.dto.BookTradeOfferRequestDto;
import mk.ukim.finki.eimt.booktrading.booktrade.domain.repository.BookTradeOfferRepository;
import org.springframework.stereotype.Service;

@Service
public class TradeOfferApplicationService {

    private final BookTradeOfferRepository bookTradeOfferRepository;

    public TradeOfferApplicationService(
            BookTradeOfferRepository bookTradeOfferRepository
    ) {
        this.bookTradeOfferRepository = bookTradeOfferRepository;
    }

    public BookTradeOffer createNewBookTradeOffer(BookTradeOfferRequestDto bookTradeOfferRequestDto) {
        BookTradeOffer bookTradeOffer = BookTradeOffer.valueOf(bookTradeOfferRequestDto);
        return bookTradeOfferRepository.save(bookTradeOffer);
    }

}
