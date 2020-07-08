package mk.ukim.finki.eimt.booktrading.booktrade.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Getter
@Embeddable
@EqualsAndHashCode(callSuper = false)
public class UserId extends DomainObjectId {

    protected UserId() {
        super("");
    }

    public UserId(String id) {
        super(id);
    }

}
