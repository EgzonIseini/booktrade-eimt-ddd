package mk.ukim.finki.eimt.booktrading.usermanagement.controller;

import mk.ukim.finki.eimt.booktrading.usermanagement.application.UserApplicationService;
import mk.ukim.finki.eimt.booktrading.usermanagement.domain.model.User;
import mk.ukim.finki.eimt.booktrading.usermanagement.domain.model.dto.CreateUserRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserApplicationService userApplicationService;

    public UserController(
            UserApplicationService userApplicationService
    ) {
        this.userApplicationService = userApplicationService;
    }

    @PostMapping
    public User createNewUser(@RequestBody CreateUserRequestDto userRequestDto) {
        return this.userApplicationService.createNewUser(userRequestDto);
    }

}
