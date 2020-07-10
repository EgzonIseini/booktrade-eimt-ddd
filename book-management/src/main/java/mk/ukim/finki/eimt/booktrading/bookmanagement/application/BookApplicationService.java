package mk.ukim.finki.eimt.booktrading.bookmanagement.application;

import mk.ukim.finki.eimt.booktrading.bookmanagement.domain.model.Book;
import mk.ukim.finki.eimt.booktrading.bookmanagement.domain.model.BookId;
import mk.ukim.finki.eimt.booktrading.bookmanagement.domain.model.dto.CreateNewBookRequestDto;
import mk.ukim.finki.eimt.booktrading.bookmanagement.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookApplicationService {

    private final BookRepository bookRepository;

    public BookApplicationService(
            BookRepository bookRepository
    ) {
        this.bookRepository = bookRepository;
    }

    public Book createNewBook(CreateNewBookRequestDto createNewBookRequestDto) {
        Book newBook = Book.valueOf(createNewBookRequestDto);
        return bookRepository.save(newBook);
    }

    public Book getBookById(BookId bookId) {
        return bookRepository.findById(bookId).orElseThrow(RuntimeException::new);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Page<Book> getBookPageable(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

}
