package com.example.booklibraryspringboot.dto.category;

import com.example.booklibraryspringboot.entity.BookEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class CategoryDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)

    private Long id;

    private String categoryName;

}
