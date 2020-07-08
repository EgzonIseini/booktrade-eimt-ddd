package mk.ukim.finki.eimt.booktrading.booktrade.domain.model;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "book_trade_offers")
public class BookTradeOffer extends AbstractEntity<BookTradeOfferId> {

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "first_party_uid", nullable = false))
    private final UserId firstPartyId;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "second_party_uid", nullable = false))
    private final UserId secondPartyId;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "required_book_id", nullable = false))
    private BookId requiredBookId;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "offered_book_id", nullable = false))
    private BookId offeredBookId;

    @Column(name = "book_trade_length", nullable = false)
    private LocalDateTime bookTradeLength;

    protected BookTradeOffer() {
        this.firstPartyId = null;
        this.secondPartyId = null;
    }

    public BookTradeOffer(
            @NonNull UserId firstPartyId,
            @NonNull UserId secondPartyId,
            @NonNull BookId requiredBookId,
            @NonNull BookId offeredBookId,
            @NonNull LocalDateTime bookTradeLength
    ) {
        super(DomainObjectId.randomId(BookTradeOfferId.class));
        this.firstPartyId = firstPartyId;
        this.secondPartyId = secondPartyId;
        setRequiredBookId(requiredBookId);
        setOfferedBookId(offeredBookId);
        setBookTradeLength(bookTradeLength);
    }

    public void setRequiredBookId(BookId requiredBookId) {
        this.requiredBookId = requiredBookId;
    }

    public void setOfferedBookId(BookId offeredBookId) {
        this.offeredBookId = offeredBookId;
    }

    public void setBookTradeLength(LocalDateTime bookTradeLength) {
        if(bookTradeLength.isBefore(LocalDateTime.of(bookTradeLength.toLocalDate(), bookTradeLength.toLocalTime()).plusDays(7))) {
            throw new IllegalArgumentException("Book trade length should be longer than 7 days.");
        }
        this.bookTradeLength = bookTradeLength;
    }
}
