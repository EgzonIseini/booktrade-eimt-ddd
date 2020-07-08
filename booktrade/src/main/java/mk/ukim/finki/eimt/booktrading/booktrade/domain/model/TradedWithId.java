package mk.ukim.finki.eimt.booktrading.booktrade.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Getter
@Embeddable
@EqualsAndHashCode(callSuper = false)
public class TradedWithId extends DomainObjectId {

    protected TradedWithId() {
        super("");
    }

    public TradedWithId(String id) {
        super(id);
    }

}
