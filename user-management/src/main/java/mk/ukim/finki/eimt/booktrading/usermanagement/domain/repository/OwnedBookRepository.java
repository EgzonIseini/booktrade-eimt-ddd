package mk.ukim.finki.eimt.booktrading.usermanagement.domain.repository;

import mk.ukim.finki.eimt.booktrading.usermanagement.domain.model.OwnedBook;
import mk.ukim.finki.eimt.booktrading.usermanagement.domain.model.OwnedBookId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnedBookRepository extends JpaRepository<OwnedBook, OwnedBookId> {
}
