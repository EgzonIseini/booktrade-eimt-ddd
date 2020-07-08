package mk.ukim.finki.eimt.booktrading.booktrade.domain.model;


import lombok.Getter;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class BookTradeId extends DomainObjectId {

    protected BookTradeId() {
        super("");
    }

    public BookTradeId(String id) {
        super(id);
    }

}
