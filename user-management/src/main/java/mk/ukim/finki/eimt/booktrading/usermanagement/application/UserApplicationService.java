package mk.ukim.finki.eimt.booktrading.usermanagement.application;

import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.info.Email;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.info.FullName;
import mk.ukim.finki.eimt.booktrading.usermanagement.domain.model.User;
import mk.ukim.finki.eimt.booktrading.usermanagement.domain.model.dto.CreateUserRequestDto;
import mk.ukim.finki.eimt.booktrading.usermanagement.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserApplicationService {

    private final UserRepository userRepository;

    public UserApplicationService(
            UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }

    public User createNewUser(CreateUserRequestDto userRequestDto) {
        User newUser = User.valueOf(userRequestDto);
        return userRepository.save(newUser);
    }
}
