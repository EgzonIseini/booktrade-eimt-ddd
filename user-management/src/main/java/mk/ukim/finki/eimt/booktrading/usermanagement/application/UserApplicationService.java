package mk.ukim.finki.eimt.booktrading.usermanagement.application;

import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.info.Email;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.info.FullName;
import mk.ukim.finki.eimt.booktrading.usermanagement.domain.model.BookId;
import mk.ukim.finki.eimt.booktrading.usermanagement.domain.model.OwnedBook;
import mk.ukim.finki.eimt.booktrading.usermanagement.domain.model.User;
import mk.ukim.finki.eimt.booktrading.usermanagement.domain.model.UserId;
import mk.ukim.finki.eimt.booktrading.usermanagement.domain.model.dto.CreateUserRequestDto;
import mk.ukim.finki.eimt.booktrading.usermanagement.domain.repository.OwnedBookRepository;
import mk.ukim.finki.eimt.booktrading.usermanagement.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;

@Service
@Transactional
public class UserApplicationService {

    private final UserRepository userRepository;
    private final OwnedBookRepository ownedBookRepository;

    public UserApplicationService(
            UserRepository userRepository,
            OwnedBookRepository ownedBookRepository
    ) {
        this.userRepository = userRepository;
        this.ownedBookRepository = ownedBookRepository;
    }

    public User createNewUser(CreateUserRequestDto userRequestDto) {
        User newUser = User.valueOf(userRequestDto);
        return userRepository.save(newUser);
    }
    public void deleteUser(String ID)
    {
       userRepository.deleteById(new UserId(ID));
    }

    public User addBook(String userID, String bookID)
    {
        User user = userRepository.findById(new UserId(userID)).orElseThrow(RuntimeException::new);
        OwnedBook ownedBook = new OwnedBook(Instant.now(),new BookId(bookID));
        ownedBookRepository.save(ownedBook);
        user.getBooks().add(ownedBook);
        return userRepository.save(user);

    }


}
