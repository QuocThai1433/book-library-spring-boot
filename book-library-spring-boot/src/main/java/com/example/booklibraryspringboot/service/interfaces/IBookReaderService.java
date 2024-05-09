package com.example.booklibraryspringboot.service.interfaces;

import com.example.booklibraryspringboot.dto.book_reader.BookReaderDTO;

import java.util.List;

public interface IBookReaderService {
    BookReaderDTO create(BookReaderDTO bookReader);

    BookReaderDTO update(BookReaderDTO bookReader, Long id);

    BookReaderDTO getById(Long id);

    List<BookReaderDTO> getList();

    Boolean delete(Long id);
}
