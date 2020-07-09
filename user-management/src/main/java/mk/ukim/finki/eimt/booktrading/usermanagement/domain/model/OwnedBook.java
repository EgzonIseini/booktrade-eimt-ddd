package mk.ukim.finki.eimt.booktrading.usermanagement.domain.model;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "owned_books")
@Getter
public class OwnedBook extends AbstractEntity<OwnedBookId> {

    @Column(name = "purchased_time")
    private Instant purchase;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "book_id", nullable = false))
    private BookId bookId;

    @Column(name = "book_available", nullable = false)
    private Boolean available;

    protected OwnedBook() {
    }

    public OwnedBook(@NonNull Instant purchase) {
        super(DomainObjectId.randomId(OwnedBookId.class));
        setPurchase(purchase);
    }

    public Instant getPurchase() {
        return purchase;
    }

    public void setPurchase(Instant purchase) {
        this.purchase = purchase;
    }

}
