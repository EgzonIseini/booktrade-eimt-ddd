package mk.ukim.finki.eimt.booktrading.booktrade.domain.service;

import mk.ukim.finki.eimt.booktrading.booktrade.domain.model.BookId;
import mk.ukim.finki.eimt.booktrading.booktrade.domain.model.BookTradeOffer;
import mk.ukim.finki.eimt.booktrading.booktrade.domain.model.dto.BookTradeOfferRequestDto;
import org.springframework.stereotype.Service;

@Service
public class BookTradeOfferDomainService {

    public BookTradeOffer counterOffer(BookTradeOffer existingOffer, BookTradeOfferRequestDto newOfferDto) {
        existingOffer.setBookTradeLength(newOfferDto.getTradeEndingDate());
        existingOffer.setOfferedBookId(new BookId(newOfferDto.getOfferedBook()));
        existingOffer.setRequiredBookId(new BookId(newOfferDto.getRequestedBook()));
        return existingOffer;
    }

}
