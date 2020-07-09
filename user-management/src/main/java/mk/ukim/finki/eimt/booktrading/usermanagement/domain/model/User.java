package mk.ukim.finki.eimt.booktrading.usermanagement.domain.model;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.info.Email;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.info.FullName;
import mk.ukim.finki.eimt.booktrading.usermanagement.domain.model.dto.CreateUserRequestDto;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;
import java.util.Set;


@Entity
@Table(name = "users")
@Getter
public class User extends AbstractEntity<UserId> {

    @Version
    private Long version;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "first_name", nullable = false)),
            @AttributeOverride(name = "lastName", column = @Column(name = "last_name", nullable = false))
    })
    private FullName fullname;


    @Embedded
    @AttributeOverride(name = "email", column = @Column(name = "email_address", nullable = false))
    private Email email;

    @OneToMany(cascade =  CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<OwnedBook> books;

    protected User()
    {

    }

    public User(@NonNull FullName fullName, @NonNull Email email)
    {
        super(DomainObjectId.randomId(UserId.class));
        setEmail(email);
        setFullname(fullName);
    }

    public static User valueOf(CreateUserRequestDto userRequestDto) {
        return new User(
                new FullName(userRequestDto.getFirstName(), userRequestDto.getLastName()),
                new Email(userRequestDto.getEmail())
        );
    }


    public void setFullname(FullName fullname) {
        this.fullname = fullname;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

}
