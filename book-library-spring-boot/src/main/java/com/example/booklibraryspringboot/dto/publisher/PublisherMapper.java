package com.example.booklibraryspringboot.dto.publisher;

import com.example.booklibraryspringboot.entity.PublisherEntity;
import org.springframework.stereotype.Component;

@Component
public class PublisherMapper {
    public PublisherEntity toEntity(PublisherDTO dto) {
        return PublisherEntity.builder()
                .id(dto.getId())
                .publisherName(dto.getPublisherName())
                .build();

    }
    public PublisherEntity toEntity(PublisherDTO dto,Long id) {
        return PublisherEntity.builder()
                .id(id)
                .publisherName(dto.getPublisherName())
                .build();

    }

    public PublisherDTO toDTO(PublisherEntity entity) {
        return PublisherDTO.builder()
                .id(entity.getId())
                .publisherName(entity.getPublisherName())
                .build();
    }
}
