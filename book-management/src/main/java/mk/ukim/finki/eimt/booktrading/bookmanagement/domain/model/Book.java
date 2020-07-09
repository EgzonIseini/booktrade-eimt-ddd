package mk.ukim.finki.eimt.booktrading.bookmanagement.domain.model;

import com.fasterxml.jackson.databind.util.ClassUtil;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.eimt.booktrading.bookmanagement.domain.model.dto.CreateNewBookRequestDto;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.eimt.booktrading.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "books")
@Getter
public class Book extends AbstractEntity<BookId> {

    @Version
    private Long version;

    @Column(name = "book_name", nullable = false)
    private String bookName;

    @Embedded
    private Rating rating;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "author_id"))
    private AuthorId authorId;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "publisher_id"))
    private PublisherId publisherId;

    public Book() {}

    private Book(String bookName, @NonNull Rating rating, AuthorId authorId, PublisherId publisherId) {
        super(DomainObjectId.randomId(BookId.class));
        changeBookName(bookName);
        setRating(rating);
        setAuthor(authorId);
        setPublisher(publisherId);
    }

    public static Book valueOf(CreateNewBookRequestDto createNewBookRequestDto) {
        return new Book(
                createNewBookRequestDto.getBookName(),
                new Rating(createNewBookRequestDto.getRating()),
                new AuthorId(createNewBookRequestDto.getAuthorId()),
                new PublisherId(createNewBookRequestDto.getPublisherId())
        );
    }

    public void changeBookName(String newName) {
        Objects.requireNonNull(newName, "Book name can't be null.");
        this.bookName = newName;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public void setAuthor(AuthorId authorId) {
        Objects.requireNonNull(authorId, "Author ID can't be null.");
        this.authorId = authorId;
    }

    public void setPublisher(PublisherId publisherId) {
        Objects.requireNonNull(authorId, "Publisher ID can't be null.");
        this.publisherId = publisherId;
    }

    public void clearAuthor() { this.authorId = null; }

    public void clearPublisher() { this.publisherId = null; }

}
