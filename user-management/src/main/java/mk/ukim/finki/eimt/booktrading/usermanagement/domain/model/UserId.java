package mk.ukim.finki.eimt.booktrading.usermanagement.domain.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@EqualsAndHashCode
public class UserId extends DomainObjectId {

    private UserId() {
        super("");
    }

    public UserId(@NonNull String id) {
        super(id);
    }
}
