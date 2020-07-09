package mk.ukim.finki.eimt.booktrading.bookmanagement.domain.repository;

import mk.ukim.finki.eimt.booktrading.bookmanagement.domain.model.Book;
import mk.ukim.finki.eimt.booktrading.bookmanagement.domain.model.BookId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, BookId> {
}
