package com.example.booklibraryspringboot.dto.author;

import com.example.booklibraryspringboot.dto.author.AuthorDTO;
import com.example.booklibraryspringboot.entity.AuthorEntity;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {
    public AuthorEntity toEntity(AuthorDTO dto) {
        return AuthorEntity.builder()
                .id(dto.getId())
                .authorName(dto.getAuthorName())
                .build();

    }
    public AuthorEntity toEntity(AuthorDTO dto,Long id) {
        return AuthorEntity.builder()
                .id(id)
                .authorName(dto.getAuthorName())
                .build();

    }
    public AuthorDTO toDTO(AuthorEntity entity) {
        return AuthorDTO.builder()
                .id(entity.getId())
                .authorName(entity.getAuthorName())
                .build();
    }
}
