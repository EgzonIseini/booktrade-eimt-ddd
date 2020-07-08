package mk.ukim.finki.eimt.booktrading.usermanagement.domain.model;

import lombok.Getter;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class BookOwnedID extends DomainObjectId {

    protected BookOwnedID()
    {
        super("");
    }
    public BookOwnedID(String id)
    {
        super(id);
    }
}
