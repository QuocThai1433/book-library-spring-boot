package com.example.booklibraryspringboot.dto.book;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class BookStatisticsRequest {
    private String bookName;
    private String categoryName;
    private int total;
}
