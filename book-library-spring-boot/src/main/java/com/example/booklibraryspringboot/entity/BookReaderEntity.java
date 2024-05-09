package com.example.booklibraryspringboot.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.sql.Date;

@Table(name = "book_reader")
@Getter
@Setter
@Entity
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class BookReaderEntity {


    @EmbeddedId
    private IdDTO id;

    @ManyToOne
    @MapsId("book_id")
    @JoinColumn(name = "book_id")
    private BookEntity bookId;

    @ManyToOne
    @MapsId("reader_id")
    @JoinColumn(name = "reader_id")
    private ReaderEntity readerId;

    @Column(name = "borrowed_day")
    private Date borrowedDay;

    @Column(name = "return_day")
    private Date returnDay;
}
