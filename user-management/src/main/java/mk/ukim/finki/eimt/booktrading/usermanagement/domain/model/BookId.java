package mk.ukim.finki.eimt.booktrading.usermanagement.domain.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class BookId extends DomainObjectId {

    protected BookId() {
        super("");
    }

    public BookId(String id) {
        super(id);
    }

}