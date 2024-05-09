package com.example.booklibraryspringboot.service.interfaces;

import com.example.booklibraryspringboot.dto.reader.ReaderDTO;

import java.util.List;

public interface IReaderService {
    ReaderDTO create(ReaderDTO author);

    ReaderDTO update(ReaderDTO author, Long id);

    ReaderDTO getById(Long id);

    List<ReaderDTO> getList();

    Boolean delete(Long id);
}
