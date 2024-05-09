package com.example.booklibraryspringboot.service;

import com.example.booklibraryspringboot.dto.reader.ReaderDTO;
import com.example.booklibraryspringboot.dto.reader.ReaderMapper;
import com.example.booklibraryspringboot.entity.ReaderEntity;
import com.example.booklibraryspringboot.repository.ReaderRepository;
import com.example.booklibraryspringboot.service.interfaces.IReaderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class ReaderService implements IReaderService {
    public final ReaderRepository repository;

    public  final ReaderMapper mapper;
    public ReaderService(ReaderRepository repository, ReaderMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ReaderDTO create(ReaderDTO dto) {
        ReaderEntity entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public ReaderDTO update(ReaderDTO dto, Long id) {
        ReaderEntity entity = mapper.toEntity(dto,id);
        if (getById(id) == null) {
            return null;
        } else
            return mapper.toDTO(repository.save(entity));
    }

    @Override
    public ReaderDTO getById(Long id) {
        return this.repository.findById(id)
                .map(this.mapper::toDTO)
                .orElseThrow(
                        () -> new RuntimeException("Movie not found")
                );
    }

    @Override
    public List<ReaderDTO> getList() {

        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean delete(Long id) {
        if (getById(id) == null) {
            return null;
        } else
            repository.deleteById(id);
        return true;
    }
}
