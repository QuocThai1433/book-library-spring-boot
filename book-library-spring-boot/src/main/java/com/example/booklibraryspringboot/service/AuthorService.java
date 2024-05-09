package com.example.booklibraryspringboot.service;

import com.example.booklibraryspringboot.dto.author.AuthorDTO;
import com.example.booklibraryspringboot.dto.author.AuthorMapper;
import com.example.booklibraryspringboot.entity.AuthorEntity;
import com.example.booklibraryspringboot.repository.AuthorRepository;
import com.example.booklibraryspringboot.service.interfaces.IAuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService implements IAuthorService {
    public final AuthorRepository repository;
    public final AuthorMapper mapper;

    public AuthorService(AuthorRepository repository, AuthorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public AuthorDTO create(AuthorDTO dto) {
        AuthorEntity entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public AuthorDTO update(AuthorDTO dto, Long id) {
        AuthorEntity entity = mapper.toEntity(dto, id);
        if (getById(id) == null) {
            return null;
        } else
            entity.setAuthorName(dto.getAuthorName());
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public AuthorDTO getById(Long id) {
        return this.repository.findById(id)
                .map(this.mapper::toDTO)
                .orElseThrow(
                        () -> new RuntimeException("Movie not found")
                );
    }

    @Override
    public List<AuthorDTO> getList() {

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
