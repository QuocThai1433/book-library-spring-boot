package com.example.booklibraryspringboot.dto.book;

import com.example.booklibraryspringboot.entity.AuthorEntity;
import com.example.booklibraryspringboot.entity.BookEntity;
import com.example.booklibraryspringboot.entity.CategoryEntity;
import com.example.booklibraryspringboot.entity.PublisherEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookMapper {
    public BookEntity toEntity(BookDTO dto) {
        return BookEntity.builder()
                .id(dto.getId())
                .bookName(dto.getBookName())
                .publicationYear(dto.getPublicationYear())
                .quantity(dto.getQuantity())
                .price(dto.getPrice())
                .ratingAverage(dto.getRatingAverage())
                .category(CategoryEntity.builder().id(dto.getCategoryId()).build())
                .author(AuthorEntity.builder().id(dto.getAuthorId()).build())
                .publisher(PublisherEntity.builder().id(dto.getPublisherId()).build())
                .build();
    }
    public BookEntity toEntity(BookDTO dto,Long id) {
        return BookEntity.builder()
                .id(id)
                .bookName(dto.getBookName())
                .publicationYear(dto.getPublicationYear())
                .quantity(dto.getQuantity())
                .price(dto.getPrice())
                .ratingAverage(dto.getRatingAverage())
                .category(CategoryEntity.builder().id(dto.getCategoryId()).build())
                .author(AuthorEntity.builder().id(dto.getAuthorId()).build())
                .publisher(PublisherEntity.builder().id(dto.getPublisherId()).build())
                .build();
    }
    public FilterBookRequest toDTOFilter (BookEntity entity) {
        return FilterBookRequest.builder()
                .id(entity.getId())
                .bookName(entity.getBookName())
                .build();

    }
    public BookDTO toDTO(BookEntity entity) {
        return BookDTO.builder()
                .id(entity.getId())
                .id(entity.getId())
                .bookName(entity.getBookName())
                .publicationYear(entity.getPublicationYear())
                .quantity(entity.getQuantity())
                .price(entity.getPrice())
                .ratingAverage(entity.getRatingAverage())
                .categoryId(entity.getCategory().getId())
                .authorId(entity.getAuthor().getId())
                .publisherId(entity.getPublisher().getId())
                .build();
    }
}
