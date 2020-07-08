package mk.ukim.finki.eimt.booktrading.usermanagement.domain.model;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.AbstractEntity;
import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "books_owned")
@Getter
public class BookOwned extends AbstractEntity<BookOwnedID> {

    @Column(name = "purchased_time")
    private Instant purchase;

    @Embedded
    @AttributeOverride(name = "id",column = @Column(name = "book_id",nullable = false))
    private BookId bookId;

    protected BookOwned()
    {}

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
