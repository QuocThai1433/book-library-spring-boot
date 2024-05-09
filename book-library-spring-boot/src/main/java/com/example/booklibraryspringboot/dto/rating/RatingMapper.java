package com.example.booklibraryspringboot.dto.rating;

import com.example.booklibraryspringboot.entity.BookEntity;
import com.example.booklibraryspringboot.entity.RatingEntity;
import com.example.booklibraryspringboot.entity.ReaderEntity;
import org.springframework.stereotype.Component;

@Component
public class RatingMapper {
    public RatingEntity toEntity(RatingDTO dto) {
        return RatingEntity.builder()
                .id(dto.getId())
                .starRating(dto.getStarRating())
                .comment(dto.getComment())
                .readerId(ReaderEntity.builder().id(dto.getReaderId()).build())
                .bookId(BookEntity.builder().id(dto.getBookId()).build())
                .build();

    }
    public RatingEntity toEntity(RatingDTO dto,Long id) {
        return RatingEntity.builder()
                .id(id)
                .starRating(dto.getStarRating())
                .comment(dto.getComment())
                .readerId(ReaderEntity.builder().id(dto.getReaderId()).build())
                .bookId(BookEntity.builder().id(dto.getBookId()).build())
                .build();

    }

    public RatingDTO toDTO(RatingEntity entity) {
        return RatingDTO.builder()
                .id(entity.getId())
                .starRating(entity.getStarRating())
                .comment(entity.getComment())
                .readerId(entity.getReaderId().getId())
                .bookId(entity.getBookId().getId())
                .build();
    }
}
