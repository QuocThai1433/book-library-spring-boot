package com.example.booklibraryspringboot.dto.book_reader;

import com.example.booklibraryspringboot.dto.book_reader.BookReaderDTO;
import com.example.booklibraryspringboot.entity.BookEntity;
import com.example.booklibraryspringboot.entity.BookReaderEntity;
import com.example.booklibraryspringboot.entity.ReaderEntity;
import org.springframework.stereotype.Component;

@Component
public class BookReaderMapper {


    public BookReaderEntity toEntity(BookReaderDTO dto) {
        return BookReaderEntity.builder()
                .bookId(BookEntity.builder()
                        .id(dto.getBookId())
                        .build())
                .readerId(ReaderEntity.builder()
                        .id(dto.getReaderId())
                        .build())
                .borrowedDay(dto.getBorrowedDay())
                .returnDay(dto.getReturnDay())

                .build();

    }

    public BookReaderEntity toEntity(BookReaderDTO dto, Long id) {
        return BookReaderEntity.builder()
                .bookId(BookEntity.builder()
                        .id(dto.getBookId())
                        .build())
                .readerId(ReaderEntity.builder()
                        .id(dto.getReaderId())
                        .build())
                .borrowedDay(dto.getBorrowedDay())
                .returnDay(dto.getReturnDay())

                .build();

    }

    public BookReaderDTO toDTO(BookReaderEntity entity) {
        return BookReaderDTO.builder()
                .bookId(entity.getBookId().getId())
                .readerId(entity.getReaderId().getId())
                .borrowedDay(entity.getBorrowedDay())
                .returnDay(entity.getReturnDay())
                .build();
    }
}
