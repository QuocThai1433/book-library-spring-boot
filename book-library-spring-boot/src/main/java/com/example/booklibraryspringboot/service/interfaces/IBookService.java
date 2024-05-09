package com.example.booklibraryspringboot.service.interfaces;

import com.example.booklibraryspringboot.dto.book.BookDTO;

import java.util.List;

public interface IBookService {
    BookDTO create(BookDTO author);

    BookDTO update(BookDTO author, Long id);

    BookDTO getById(Long id);

    List<BookDTO> getList();

    Boolean delete(Long id);
}
