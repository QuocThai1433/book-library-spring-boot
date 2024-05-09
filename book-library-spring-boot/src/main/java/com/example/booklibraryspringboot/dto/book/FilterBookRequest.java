package com.example.booklibraryspringboot.dto.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class FilterBookRequest {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private String bookName;


}
