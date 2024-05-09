package com.example.booklibraryspringboot.dto.rating;

import com.example.booklibraryspringboot.entity.BookEntity;
import com.example.booklibraryspringboot.entity.ReaderEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class RatingDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)

    private Long id;

    private int starRating;

    private String comment;

    private Long bookId;

    private Long readerId;
}
