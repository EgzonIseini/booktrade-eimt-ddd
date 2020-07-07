package mk.ukim.finki.eimt.booktrading.sharedkernel.domain.info;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.NonNull;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.ValueObject;

import javax.persistence.Column;
import java.util.Objects;

public class Email  implements ValueObject {
    @Column(name = "email_address")
    private final String email;

    private Email()
    {
        this.email= null;
    }

    @JsonCreator
    public Email(@NonNull String email)
    {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email1 = (Email) o;
        return Objects.equals(email, email1.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    @JsonValue
    public String toString()
    {
        return email;
    }
}
