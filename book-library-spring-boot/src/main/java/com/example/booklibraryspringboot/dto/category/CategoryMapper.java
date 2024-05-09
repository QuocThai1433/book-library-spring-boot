package com.example.booklibraryspringboot.dto.category;

import com.example.booklibraryspringboot.dto.book.BookDTO;
import com.example.booklibraryspringboot.dto.book.BookStatisticsRequest;
import com.example.booklibraryspringboot.entity.CategoryEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CategoryMapper {
    public CategoryEntity toEntity(CategoryDTO dto) {
        return CategoryEntity.builder()
                .id(dto.getId())
                .categoryName(dto.getCategoryName())
                .build();

    }

    public CategoryEntity toEntity(CategoryDTO dto,Long id) {
        return CategoryEntity.builder()
                .id(id)
                .categoryName(dto.getCategoryName())
                .build();

    }

    public CategoryDTO toDTO(CategoryEntity entity) {
        return CategoryDTO.builder()
                .id(entity.getId())
                .categoryName(entity.getCategoryName())
                .build();
    }
}
