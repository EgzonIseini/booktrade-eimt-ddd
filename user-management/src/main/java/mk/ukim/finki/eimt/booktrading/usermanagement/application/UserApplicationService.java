package mk.ukim.finki.eimt.booktrading.usermanagement.application;

import mk.ukim.finki.eimt.booktrading.usermanagement.domain.model.*;
import mk.ukim.finki.eimt.booktrading.usermanagement.domain.model.dto.CreateUserRequestDto;
import mk.ukim.finki.eimt.booktrading.usermanagement.repository.OwnedBookRepository;
import mk.ukim.finki.eimt.booktrading.usermanagement.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;

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

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(String ID) {
        userRepository.deleteById(new UserId(ID));
    }

    public User addBook(String userID, String bookID) {
        User user = userRepository.findById(new UserId(userID)).orElseThrow(RuntimeException::new);
        OwnedBook ownedBook = new OwnedBook(Instant.now(), new BookId(bookID));
        ownedBookRepository.save(ownedBook);
        user.getBooks().add(ownedBook);
        return userRepository.save(user);

    }

    public OwnedBook setBookAvailability(OwnedBookId ownedBookId, Boolean availability) {
        var book = ownedBookRepository.findById(ownedBookId).orElseThrow(RuntimeException::new);
        book.setAvailable(availability);
        return ownedBookRepository.save(book);
    }

    public Page<OwnedBook> getAllAvailableBooks(Pageable pageable) {
        return ownedBookRepository.findAllByAvailableTrue(pageable);
    }

}
