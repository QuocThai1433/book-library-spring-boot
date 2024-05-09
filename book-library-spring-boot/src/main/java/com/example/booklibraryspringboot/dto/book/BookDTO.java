package com.example.booklibraryspringboot.dto.book;

import com.example.booklibraryspringboot.entity.AuthorEntity;
import com.example.booklibraryspringboot.entity.CategoryEntity;
import com.example.booklibraryspringboot.entity.PublisherEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class BookDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private String bookName;

    private String publicationYear;

    private String quantity;

    private String price;

    private String ratingAverage;

    private Long categoryId;

    private Long authorId;

    private Long publisherId;
}
