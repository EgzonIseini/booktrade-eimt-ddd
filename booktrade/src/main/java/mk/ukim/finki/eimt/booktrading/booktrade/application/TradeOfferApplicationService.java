package mk.ukim.finki.eimt.booktrading.booktrade.application;

import mk.ukim.finki.eimt.booktrading.booktrade.domain.model.BookTradeOffer;
import mk.ukim.finki.eimt.booktrading.booktrade.domain.model.BookTradeOfferId;
import mk.ukim.finki.eimt.booktrading.booktrade.domain.model.UserId;
import mk.ukim.finki.eimt.booktrading.booktrade.domain.model.dto.BookTradeOfferRequestDto;
import mk.ukim.finki.eimt.booktrading.booktrade.domain.service.BookTradeOfferDomainService;
import mk.ukim.finki.eimt.booktrading.booktrade.repository.BookTradeOfferRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TradeOfferApplicationService {

    private final BookTradeOfferRepository bookTradeOfferRepository;
    private final BookTradeOfferDomainService bookTradeOfferDomainService;

    public TradeOfferApplicationService(
            BookTradeOfferRepository bookTradeOfferRepository,
            BookTradeOfferDomainService bookTradeOfferDomainService
    ) {
        this.bookTradeOfferRepository = bookTradeOfferRepository;
        this.bookTradeOfferDomainService = bookTradeOfferDomainService;
    }

    public List<BookTradeOffer> getAllBookTradeOffers() {
        return bookTradeOfferRepository.findAll();
    }

    public BookTradeOffer createNewBookTradeOffer(BookTradeOfferRequestDto bookTradeOfferRequestDto) {
        BookTradeOffer bookTradeOffer = BookTradeOffer.valueOf(bookTradeOfferRequestDto);
        return bookTradeOfferRepository.save(bookTradeOffer);
    }

    public BookTradeOffer counterOffer(BookTradeOfferId oldOfferId, BookTradeOfferRequestDto bookTradeOfferRequestDto) {
        var oldOffer = bookTradeOfferRepository.findById(oldOfferId).orElseThrow(RuntimeException::new);
        var newOffer = bookTradeOfferDomainService.counterOffer(oldOffer, bookTradeOfferRequestDto);
        return bookTradeOfferRepository.save(newOffer);
    }

    public List<BookTradeOffer> getAllBookTradeOffersForUserId(UserId userId) {
        return bookTradeOfferRepository.findAllByFirstPartyId(userId);
    }

}
