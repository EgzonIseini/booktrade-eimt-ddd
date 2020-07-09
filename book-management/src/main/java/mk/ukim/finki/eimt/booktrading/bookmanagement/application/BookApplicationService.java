package mk.ukim.finki.eimt.booktrading.bookmanagement.application;

import mk.ukim.finki.eimt.booktrading.bookmanagement.BookManagementApplication;
import mk.ukim.finki.eimt.booktrading.bookmanagement.domain.model.Book;
import mk.ukim.finki.eimt.booktrading.bookmanagement.domain.model.BookId;
import mk.ukim.finki.eimt.booktrading.bookmanagement.domain.model.dto.CreateNewBookRequestDto;
import mk.ukim.finki.eimt.booktrading.bookmanagement.domain.repository.BookRepository;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookApplicationService {

    private final BookRepository bookRepository;
    private final RabbitTemplate rabbitTemplate;

    public BookApplicationService(
            BookRepository bookRepository,
            RabbitTemplate rabbitTemplate
    ) {
        this.bookRepository = bookRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    public Book createNewBook(CreateNewBookRequestDto createNewBookRequestDto) {
        Book newBook = Book.valueOf(createNewBookRequestDto);
        sendBookCreated(newBook.getId());
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

    private void sendBookCreated(BookId bookId) {
        Map<String, String> actionMap = new HashMap<>();
        actionMap.put("ACTION", "CREATED");
        actionMap.put("BookId", bookId.toString());
        this.rabbitTemplate.convertAndSend(BookManagementApplication.BOOKS_QUEUE, actionMap);
    }

}
