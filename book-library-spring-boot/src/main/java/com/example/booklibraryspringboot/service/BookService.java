package com.example.booklibraryspringboot.service;

import com.example.booklibraryspringboot.dto.book.*;
import com.example.booklibraryspringboot.entity.BookEntity;
import com.example.booklibraryspringboot.entity.CategoryEntity;
import com.example.booklibraryspringboot.repository.BookRepository;
import com.example.booklibraryspringboot.service.interfaces.IBookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookService implements IBookService {
    public final BookRepository repository;
    public final BookMapper mapper;


    public BookService(BookRepository repository, BookMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public BookDTO create(BookDTO dto) {
        BookEntity entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public BookDTO update(BookDTO dto, Long id) {
        BookEntity entity = mapper.toEntity(dto, id);
        if (getById(id) == null) {
            return null;
        } else
            return mapper.toDTO(repository.save(entity));
    }

    @Override
    public BookDTO getById(Long id) {
        return this.repository.findById(id)
                .map(this.mapper::toDTO)
                .orElseThrow(
                        () -> new RuntimeException("Movie not found")
                );
    }
    @Override
    public List<BookDTO> getList() {

        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean delete(Long id) {
        if (getById(id) == null) {
            return false;
        } else
            repository.deleteById(id);
        return true;
    }

    public List<FilterBookRequest> filter(String search) {
        return repository.filter(search).stream()
                .map(mapper::toDTOFilter)
                .collect(Collectors.toList());
    }

    public Set<Map<String,BookStatisticsRequest>> bookStatistics() {
        return repository.bookStatistics();
    }

    public Double total() {
        return repository.totalBook()   ;
    }
}
