package mk.ukim.finki.eimt.booktrading.bookmanagement.application;

import mk.ukim.finki.eimt.booktrading.bookmanagement.domain.model.Book;
import mk.ukim.finki.eimt.booktrading.bookmanagement.domain.model.dto.CreateNewBookRequestDto;
import mk.ukim.finki.eimt.booktrading.bookmanagement.domain.repository.BookRepository;
import org.springframework.stereotype.Service;

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

}
