package mk.ukim.finki.eimt.booktrading.usermanagement.controller;

import mk.ukim.finki.eimt.booktrading.usermanagement.application.UserApplicationService;
import mk.ukim.finki.eimt.booktrading.usermanagement.domain.model.User;
import mk.ukim.finki.eimt.booktrading.usermanagement.domain.model.dto.CreateUserRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserApplicationService userApplicationService;

    public UserController(
            UserApplicationService userApplicationService
    ) {
        this.userApplicationService = userApplicationService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userApplicationService.getAllUsers();
    }

    @PostMapping
    public User createNewUser(@RequestBody CreateUserRequestDto userRequestDto) {
        return this.userApplicationService.createNewUser(userRequestDto);
    }

    @PostMapping("/{userID}/book/{bookID}")
    public User addOwnedBook(@PathVariable String userID, @PathVariable String bookID)
    {
        return userApplicationService.addBook(userID,bookID);
    }

    @DeleteMapping("/{id}")
    public void  deleteUser(@PathVariable String id)
    {
        userApplicationService.deleteUser(id);
    }


}
