package mk.ukim.finki.eimt.booktrading.bookmanagement.domain.model;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Entity
@Table(name = "publishers")
public class Publisher extends AbstractEntity<PublisherId> {

    private String publisherName;

    public Publisher() {}

    public Publisher(@NonNull String publisherName) {
        super(DomainObjectId.randomId(PublisherId.class));
    }

    public void changePublishersName(String newName) {
        Objects.requireNonNull(newName, "Publisher name can't be null.");
        this.publisherName = newName;
    }

}
