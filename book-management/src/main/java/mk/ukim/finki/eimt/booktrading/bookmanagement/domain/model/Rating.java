package mk.ukim.finki.eimt.booktrading.bookmanagement.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@EqualsAndHashCode
public class Rating implements ValueObject {

    @Column(name = "rating")
    private final Integer rating;

    protected Rating() {
        this.rating = null;
    }

    public Rating(Integer rating) {
        if(rating < 0) {
            throw new IllegalArgumentException("Rating cannot be lower than zero.");
        }

        this.rating = rating;
    }

    public Rating changeRating(Integer newRating) {
        return new Rating(newRating);
    }
}
