package mk.ukim.finki.eimt.booktrading.booktrade.repository;

import mk.ukim.finki.eimt.booktrading.booktrade.domain.model.BookTradeOffer;
import mk.ukim.finki.eimt.booktrading.booktrade.domain.model.BookTradeOfferId;
import mk.ukim.finki.eimt.booktrading.booktrade.domain.model.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookTradeOfferRepository extends JpaRepository<BookTradeOffer, BookTradeOfferId> {

    List<BookTradeOffer> findAllByFirstPartyId(UserId userId);

}
