package mk.ukim.finki.eimt.booktrading.usermanagement.domain.model;

import lombok.Getter;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "users")
@Getter

public class User extends AbstractEntity<UserId> {

    @Version
    private Long version;

}
