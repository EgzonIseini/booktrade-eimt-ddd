package mk.ukim.finki.eimt.booktrading.bookmanagement.controller;

import mk.ukim.finki.eimt.booktrading.bookmanagement.application.BookApplicationService;
import mk.ukim.finki.eimt.booktrading.bookmanagement.domain.model.Book;
import mk.ukim.finki.eimt.booktrading.bookmanagement.domain.model.BookId;
import mk.ukim.finki.eimt.booktrading.bookmanagement.domain.model.dto.CreateNewBookRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookApplicationService bookApplicationService;

    public BookController(
            BookApplicationService bookApplicationService
    ) {
        this.bookApplicationService = bookApplicationService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookApplicationService.getAllBooks();
    }

    @GetMapping(params = {"page", "pageSize"})
    public Page<Book> getAllBooksPageable(@RequestParam Integer page, @RequestParam Integer pageSize) {
        return bookApplicationService.getBookPageable(PageRequest.of(page, pageSize));
    }

    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable String bookId) {
        return bookApplicationService.getBookById(new BookId(bookId));
    }

    @PostMapping
    public Book createNewBook(@RequestBody CreateNewBookRequestDto createNewBookRequestDto) {
        return bookApplicationService.createNewBook(createNewBookRequestDto);
    }

}
