package com.example.booklibraryspringboot.service;

import com.example.booklibraryspringboot.dto.book_reader.BookReaderMapper;
import com.example.booklibraryspringboot.dto.book_reader.BookReaderDTO;
import com.example.booklibraryspringboot.entity.BookReaderEntity;
import com.example.booklibraryspringboot.repository.BookReaderRepository;
import com.example.booklibraryspringboot.service.interfaces.IBookReaderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookReaderService implements IBookReaderService {
    public final BookReaderRepository repository;
    public final BookReaderMapper mapper;

    public BookReaderService(BookReaderRepository repository, BookReaderMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public BookReaderDTO create(BookReaderDTO dto) {
        BookReaderEntity entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public BookReaderDTO update(BookReaderDTO dto, Long id) {
        BookReaderEntity entity = mapper.toEntity(dto,id);
        if (getById(id) == null) {
            return null;
        } else
            return mapper.toDTO(repository.save(entity));
    }

    @Override
    public BookReaderDTO getById(Long id) {
        return this.repository.findById(id)
                .map(this.mapper::toDTO)
                .orElseThrow(
                        () -> new RuntimeException("Movie not found")
                );
    }

    @Override
    public List<BookReaderDTO> getList() {

        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean delete(Long id) {
        if (getById(id) == null) {
            System.out.println("Not found id!!");
            return null;
        } else
            repository.deleteById(id);
        return true;
    }
}
