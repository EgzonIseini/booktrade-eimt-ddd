package mk.ukim.finki.eimt.booktrading.bookmanagement.domain.model;

import lombok.Getter;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.ValueObject;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
public class Rating implements ValueObject {

    @Value("${rating.max-value}")
    @Column(name = "max_rating")
    private Integer maxRating;

    @Column(name = "rating")
    private final Integer rating;

    protected Rating() {
        this.maxRating = 10;
        this.rating = 1;
    }

    public Rating(Integer rating) {

        if(rating > maxRating) {
            throw new IllegalArgumentException("Rating cannot be higher than the MAX rating.");
        } else if(rating < 0) {
            throw new IllegalArgumentException("Rating cannot be lower than zero.");
        }

        this.rating = rating;
    }

    public Rating changeRating(Integer newRating) {
        return new Rating(newRating);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating1 = (Rating) o;
        return Objects.equals(maxRating, rating1.maxRating) &&
                Objects.equals(rating, rating1.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxRating, rating);
    }
}
