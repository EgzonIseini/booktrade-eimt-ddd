package mk.ukim.finki.eimt.booktrading.usermanagement.controller;

import mk.ukim.finki.eimt.booktrading.usermanagement.application.UserApplicationService;
import mk.ukim.finki.eimt.booktrading.usermanagement.domain.model.OwnedBook;
import mk.ukim.finki.eimt.booktrading.usermanagement.domain.model.OwnedBookId;
import mk.ukim.finki.eimt.booktrading.usermanagement.domain.model.User;
import mk.ukim.finki.eimt.booktrading.usermanagement.domain.model.dto.CreateUserRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/owned-book")
public class UserOwnedBookController {

    private final UserApplicationService userApplicationService;

    public UserOwnedBookController(
            UserApplicationService userApplicationService
    ) {
        this.userApplicationService = userApplicationService;
    }

    @PostMapping
    public User createNewUser(@RequestBody CreateUserRequestDto userRequestDto) {
        return this.userApplicationService.createNewUser(userRequestDto);
    }

    @GetMapping(value = "/available", params = {"page", "pageSize"})
    public Page<OwnedBook> getAllAvailableOwnedBooks(
            @RequestParam Integer page,
            @RequestParam Integer pageSize) {
        return this.userApplicationService.getAllAvailableBooks(PageRequest.of(page, pageSize));
    }

    @PatchMapping("/{ownedBookId}/available/{availability}")
    public OwnedBook makeBookAvailable(
            @PathVariable String ownedBookId,
            @PathVariable Boolean availability) {
        return userApplicationService.setBookAvailability(new OwnedBookId(ownedBookId), availability);
    }

}
