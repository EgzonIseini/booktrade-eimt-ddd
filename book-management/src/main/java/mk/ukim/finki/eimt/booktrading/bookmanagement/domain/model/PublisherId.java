package mk.ukim.finki.eimt.booktrading.bookmanagement.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Getter
@Embeddable
@EqualsAndHashCode(callSuper = false)
public class PublisherId extends DomainObjectId {

    public PublisherId() {
        super("");
    }

    public PublisherId(String id) {
        super(id);
    }

}
