package com.example.booklibraryspringboot.dto.reader;

import com.example.booklibraryspringboot.dto.reader.ReaderDTO;
import com.example.booklibraryspringboot.entity.ReaderEntity;
import org.checkerframework.checker.units.qual.C;
import org.springframework.stereotype.Component;

@Component
public class ReaderMapper {
    public ReaderEntity toEntity(ReaderDTO dto) {
        return ReaderEntity.builder()
                .id(dto.getId())
                .readerName(dto.getReaderName())
                .build();

    }

    public ReaderEntity toEntity(ReaderDTO dto,Long id) {
        return ReaderEntity.builder()
                .id(id)
                .readerName(dto.getReaderName())
                .build();

    }

    public ReaderDTO toDTO(ReaderEntity entity) {
        return ReaderDTO.builder()
                .id(entity.getId())
                .readerName(entity.getReaderName())
                .build();
    }
}
