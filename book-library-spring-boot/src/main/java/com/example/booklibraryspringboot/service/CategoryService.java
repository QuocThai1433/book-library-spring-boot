package com.example.booklibraryspringboot.service;

import com.example.booklibraryspringboot.dto.book.BookStatisticsRequest;
import com.example.booklibraryspringboot.dto.category.CategoryMapper;
import com.example.booklibraryspringboot.dto.category.CategoryDTO;
import com.example.booklibraryspringboot.entity.CategoryEntity;
import com.example.booklibraryspringboot.repository.CategoryRepository;
import com.example.booklibraryspringboot.service.interfaces.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class CategoryService implements ICategoryService {
    public final CategoryRepository repository;
    public final CategoryMapper mapper;
    public CategoryService(CategoryRepository repository, CategoryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;

    }

    @Override
    public CategoryDTO create(CategoryDTO dto) {
        CategoryEntity entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public CategoryDTO update(CategoryDTO dto, Long id) {
        CategoryEntity entity = mapper.toEntity(dto,id);
        if (getById(id) == null) {
            return null;
        } else
            return mapper.toDTO(repository.save(entity));
    }

    @Override
    public CategoryDTO getById(Long id) {
        return this.repository.findById(id)
                .map(this.mapper::toDTO)
                .orElseThrow(
                        () -> new RuntimeException("Movie not found")
                );
    }

    @Override
    public List<CategoryDTO> getList() {

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
