package mk.ukim.finki.eimt.booktrading.booktrade.domain.repository;

import mk.ukim.finki.eimt.booktrading.booktrade.domain.model.BookTradeOffer;
import mk.ukim.finki.eimt.booktrading.booktrade.domain.model.BookTradeOfferId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookTradeOfferRepository extends JpaRepository<BookTradeOffer, BookTradeOfferId> {
}
