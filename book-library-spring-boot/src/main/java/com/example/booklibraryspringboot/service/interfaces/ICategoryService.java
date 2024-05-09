package com.example.booklibraryspringboot.service.interfaces;

import com.example.booklibraryspringboot.dto.category.CategoryDTO;

import java.util.List;

public interface ICategoryService {
    CategoryDTO create(CategoryDTO author);

    CategoryDTO update(CategoryDTO author, Long id);

    CategoryDTO getById(Long id);

    List<CategoryDTO> getList();

    Boolean delete(Long id);
}
