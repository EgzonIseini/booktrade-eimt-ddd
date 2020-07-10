package mk.ukim.finki.eimt.booktrading.booktrade.domain.model;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "book_trades")
public class BookTrade extends AbstractEntity<BookTradeId> {

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "first_party_id", nullable = false))
    private final UserId firstPartyId;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "first_party_book_id", nullable = false))
    private final BookId firstPartyBookId;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "second_party_id", nullable = false))
    private final UserId secondPartyId;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "second_party_book_id", nullable = false))
    private final BookId secondPartyBookId;

    @Column(name = "trade_ending_date", nullable = false)
    private final LocalDateTime tradeEndingDate;

    @Column(name = "trade_ended", nullable = false)
    private Boolean hasTradeEnded;

    protected BookTrade() {
        this.firstPartyId = null;
        this.secondPartyId = null;
        this.firstPartyBookId= null;
        this.secondPartyBookId = null;
        this.tradeEndingDate = null;
    }

    public BookTrade(
            @NonNull UserId firstPartyId,
            @NonNull UserId secondPartyId,
            @NonNull BookId firstPartyBookId,
            @NonNull BookId secondPartyBookId,
            @NonNull LocalDateTime tradeEndingDate,
            @NonNull Boolean hasTradeEnded
    ) {
        super(DomainObjectId.randomId(BookTradeId.class));
        if(tradeEndingDate.isBefore(LocalDateTime.now().plusDays(7))) {
            throw new IllegalArgumentException("Book trade length should be longer than 7 days.");
        }
        this.firstPartyId = firstPartyId;
        this.secondPartyId = secondPartyId;
        this.firstPartyBookId = firstPartyBookId;
        this.secondPartyBookId = secondPartyBookId;
        this.tradeEndingDate = tradeEndingDate;
        this.hasTradeEnded = hasTradeEnded;
    }

    public static BookTrade valueOf(BookTradeOffer bookTradeOffer) {
        return new BookTrade(
                bookTradeOffer.getFirstPartyId(),
                bookTradeOffer.getSecondPartyId(),
                bookTradeOffer.getOfferedBookId(),
                bookTradeOffer.getRequiredBookId(),
                bookTradeOffer.getBookTradeLength(),
                false
        );
    }

    public void setHasTradeEnded(Boolean hasTradeEnded) {
        this.hasTradeEnded = hasTradeEnded;
    }
}
