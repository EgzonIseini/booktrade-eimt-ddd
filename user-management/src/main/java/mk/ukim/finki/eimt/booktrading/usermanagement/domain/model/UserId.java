package mk.ukim.finki.eimt.booktrading.usermanagement.domain.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@EqualsAndHashCode
public class UserId extends DomainObjectId{
}
