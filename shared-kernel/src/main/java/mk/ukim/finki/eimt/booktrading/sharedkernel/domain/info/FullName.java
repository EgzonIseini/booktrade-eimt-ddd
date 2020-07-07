package mk.ukim.finki.eimt.booktrading.sharedkernel.domain.info;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.ValueObject;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
public class FullName implements ValueObject {

    @Column(name ="first_name")
    private final String firstName;

    @Column(name="last_name")
    private final String lastName;


    protected FullName()
    {
        firstName = null;
        lastName= null;
    }

    @JsonCreator
    public FullName(@NonNull String firstName, @NonNull String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

//    @NonNull
//    @JsonProperty("first_name")
//    public String getFirstName() {
//        return firstName;
//    }
//
//    @NonNull
//    @JsonProperty("last_name")
//    public String getLastName() {
//        return lastName;
//    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName,lastName);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    @JsonValue
    public String toString() {
       return firstName + lastName;
    }
}