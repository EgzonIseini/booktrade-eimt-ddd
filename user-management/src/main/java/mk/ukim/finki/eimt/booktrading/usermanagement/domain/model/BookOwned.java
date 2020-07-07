package mk.ukim.finki.eimt.booktrading.usermanagement.domain.model;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.Column;
import java.time.Instant;

@Getter
public class BookOwned extends AbstractEntity<BookId> {

    @Column(name = "purchased_time")
    private Instant purchase;

    private BookOwned()
    {

    }

    public BookOwned(@NonNull Instant purchase)
    {
        setPurchase(purchase);
    }

    public Instant getPurchase() {
        return purchase;
    }

    public void setPurchase(Instant purchase) {
        this.purchase = purchase;
    }
}
