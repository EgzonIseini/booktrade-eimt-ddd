package mk.ukim.finki.eimt.booktrading.usermanagement.repository;

import mk.ukim.finki.eimt.booktrading.usermanagement.domain.model.User;
import mk.ukim.finki.eimt.booktrading.usermanagement.domain.model.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UserId> {
}
