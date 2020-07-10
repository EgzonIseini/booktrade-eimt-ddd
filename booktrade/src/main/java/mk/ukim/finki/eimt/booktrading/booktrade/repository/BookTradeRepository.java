package mk.ukim.finki.eimt.booktrading.booktrade.repository;

import mk.ukim.finki.eimt.booktrading.booktrade.domain.model.BookTrade;
import mk.ukim.finki.eimt.booktrading.booktrade.domain.model.BookTradeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookTradeRepository extends JpaRepository<BookTrade, BookTradeId> {
}
