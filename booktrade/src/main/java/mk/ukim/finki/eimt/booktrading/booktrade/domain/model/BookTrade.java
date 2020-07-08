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
    @AttributeOverride(name = "id", column = @Column(name = "book_owner_id", nullable = false))
    private final UserId bookOwnerId;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "traded_with_id", nullable = false))
    private final UserId tradedWithId;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "book_id", nullable = false))
    private final BookId tradedBookId;

    @Column(name = "trade_ending_date", nullable = false)
    private final LocalDateTime tradeEndingDate;

    @Column(name = "trade_ended", nullable = false)
    private Boolean hasTradeEnded;

    protected BookTrade() {
        this.bookOwnerId = null;
        this.tradedWithId = null;
        this.tradedBookId = null;
        this.tradeEndingDate = null;
    }

    public BookTrade(
            @NonNull UserId bookOwnerId,
            @NonNull UserId tradedWithId,
            @NonNull BookId tradedBookId,
            @NonNull LocalDateTime tradeEndingDate,
            @NonNull Boolean hasTradeEnded
    ) {
        super(DomainObjectId.randomId(BookTradeId.class));
        if(tradeEndingDate.isBefore(LocalDateTime.of(tradeEndingDate.toLocalDate(), tradeEndingDate.toLocalTime()).plusDays(7))) {
            throw new IllegalArgumentException("Trade ending date should be longer than 7 days.");
        }
        this.bookOwnerId = bookOwnerId;
        this.tradedWithId = tradedWithId;
        this.tradedBookId = tradedBookId;
        this.tradeEndingDate = tradeEndingDate;
        this.hasTradeEnded = hasTradeEnded;
    }

    public void setHasTradeEnded(Boolean hasTradeEnded) {
        this.hasTradeEnded = hasTradeEnded;
    }
}
