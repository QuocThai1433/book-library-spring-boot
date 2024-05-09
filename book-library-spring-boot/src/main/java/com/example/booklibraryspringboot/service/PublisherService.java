package com.example.booklibraryspringboot.service;

import com.example.booklibraryspringboot.dto.publisher.PublisherMapper;
import com.example.booklibraryspringboot.dto.publisher.PublisherDTO;
import com.example.booklibraryspringboot.entity.PublisherEntity;
import com.example.booklibraryspringboot.repository.PublisherRepository;
import com.example.booklibraryspringboot.service.interfaces.IPublisherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class PublisherService implements IPublisherService {
    public final PublisherRepository repository;
    public final PublisherMapper mapper;

    public PublisherService(PublisherRepository repository, PublisherMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PublisherDTO create(PublisherDTO dto) {
        PublisherEntity entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public PublisherDTO update(PublisherDTO dto, Long id) {
        PublisherEntity entity = mapper.toEntity(dto,id);
        if (getById(id) == null) {
            return null;
        } else
            return mapper.toDTO(repository.save(entity));
    }

    @Override
    public PublisherDTO getById(Long id) {
        return this.repository.findById(id)
                .map(this.mapper::toDTO)
                .orElseThrow(
                        () -> new RuntimeException("Movie not found")
                );
    }

    @Override
    public List<PublisherDTO> getList() {

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
