package mk.ukim.finki.eimt.booktrading.bookmanagement.domain.model;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.info.FullName;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Entity
@Table(name = "authors")
public class Author extends AbstractEntity<AuthorId> {

    private FullName fullName;

    public Author() {
        this.fullName = null;
    }

    public Author(@NonNull FullName fullName) {
        super(DomainObjectId.randomId(AuthorId.class));
    }

    public void changeName(@NonNull FullName fullName) {
        this.fullName = fullName;
    }

}
