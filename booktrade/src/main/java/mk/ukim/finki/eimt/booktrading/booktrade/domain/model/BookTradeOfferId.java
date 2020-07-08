package mk.ukim.finki.eimt.booktrading.booktrade.domain.model;

import lombok.Getter;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class BookTradeOfferId extends DomainObjectId {

    protected BookTradeOfferId() {
        super("");
    }

    public BookTradeOfferId(String id) {
        super(id);
    }

}
