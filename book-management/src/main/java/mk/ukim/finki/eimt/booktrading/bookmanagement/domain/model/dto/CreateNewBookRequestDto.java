package mk.ukim.finki.eimt.booktrading.bookmanagement.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class CreateNewBookRequestDto {

    @JsonProperty("book_name")
    private final String bookName;

    @JsonProperty("rating")
    private final Integer rating;

    @JsonProperty("author_id")
    private final String authorId;

    @JsonProperty("publisher_id")
    private final String publisherId;

}
