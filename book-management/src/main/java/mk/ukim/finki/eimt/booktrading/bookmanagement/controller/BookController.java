package mk.ukim.finki.eimt.booktrading.bookmanagement.controller;

import mk.ukim.finki.eimt.booktrading.bookmanagement.application.BookApplicationService;
import mk.ukim.finki.eimt.booktrading.bookmanagement.domain.model.Book;
import mk.ukim.finki.eimt.booktrading.bookmanagement.domain.model.dto.CreateNewBookRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookApplicationService bookApplicationService;

    public BookController(
            BookApplicationService bookApplicationService
    ) {
        this.bookApplicationService = bookApplicationService;
    }

    @PostMapping
    public Book createNewBook(@RequestBody CreateNewBookRequestDto createNewBookRequestDto) {
        return bookApplicationService.createNewBook(createNewBookRequestDto);
    }

}
