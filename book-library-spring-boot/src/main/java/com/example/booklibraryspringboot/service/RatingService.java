package com.example.booklibraryspringboot.service;

import com.example.booklibraryspringboot.dto.rating.RatingDTO;
import com.example.booklibraryspringboot.dto.rating.RatingMapper;
import com.example.booklibraryspringboot.entity.RatingEntity;
import com.example.booklibraryspringboot.repository.RatingRepository;
import com.example.booklibraryspringboot.service.interfaces.IRatingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class RatingService implements IRatingService {
    public final RatingRepository repository;

    public final RatingMapper mapper;

    public RatingService(RatingRepository repository, RatingMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public RatingDTO create(RatingDTO dto) {
        RatingEntity entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public RatingDTO update(RatingDTO dto, Long id) {
        RatingEntity entity = mapper.toEntity(dto,id);
        if (getById(id) == null) {
            return null;
        } else
            return mapper.toDTO(repository.save(entity));
    }

    @Override
    public RatingDTO getById(Long id) {
        return this.repository.findById(id)
                .map(this.mapper::toDTO)
                .orElseThrow(
                        () -> new RuntimeException("Movie not found")
                );
    }

    @Override
    public List<RatingDTO> getList() {

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
