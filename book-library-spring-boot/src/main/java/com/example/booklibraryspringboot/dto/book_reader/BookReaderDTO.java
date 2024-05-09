package com.example.booklibraryspringboot.dto.book_reader;

import com.example.booklibraryspringboot.entity.IdDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.sql.Date;
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class BookReaderDTO {


    private Long bookId;

    private Long readerId;

    private Date borrowedDay;

    private Date returnDay;
}
