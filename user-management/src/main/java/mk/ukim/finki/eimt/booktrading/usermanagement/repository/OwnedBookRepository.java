package mk.ukim.finki.eimt.booktrading.usermanagement.repository;

import mk.ukim.finki.eimt.booktrading.usermanagement.domain.model.OwnedBook;
import mk.ukim.finki.eimt.booktrading.usermanagement.domain.model.OwnedBookId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OwnedBookRepository extends JpaRepository<OwnedBook, OwnedBookId> {

    Page<OwnedBook> findAllByAvailableTrue(Pageable pageable);

}
