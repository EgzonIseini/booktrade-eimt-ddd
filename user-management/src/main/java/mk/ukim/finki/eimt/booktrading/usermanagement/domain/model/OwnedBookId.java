package mk.ukim.finki.eimt.booktrading.usermanagement.domain.model;

import lombok.Getter;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class OwnedBookId extends DomainObjectId {

    protected OwnedBookId()
    {
        super("");
    }
    public OwnedBookId(String id)
    {
        super(id);
    }
}
