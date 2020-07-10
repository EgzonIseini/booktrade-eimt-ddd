package mk.ukim.finki.eimt.booktrading.booktrade.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Embeddable
@EqualsAndHashCode(callSuper = false)
public class BookId extends DomainObjectId implements Serializable {

    protected BookId() {
        super("");
    }

    public BookId(String id) {
        super(id);
    }

}
