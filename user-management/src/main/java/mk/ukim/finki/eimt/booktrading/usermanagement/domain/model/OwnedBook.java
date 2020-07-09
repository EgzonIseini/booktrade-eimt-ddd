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

    public void setBookId(BookId bookId) {
        this.bookId = bookId;
    }

    @Column(name = "book_available", nullable = false)
    private final Boolean available;

    protected OwnedBook() {
        available = true;
    }

    public OwnedBook(@NonNull Instant purchase, @NonNull BookId bookId) {
        super(DomainObjectId.randomId(OwnedBookId.class));
        setPurchase(purchase);
        setBookId(bookId);
        available=false;
    }

    public Instant getPurchase() {
        return purchase;
    }

    public void setPurchase(Instant purchase) {
        this.purchase = purchase;
    }

}
