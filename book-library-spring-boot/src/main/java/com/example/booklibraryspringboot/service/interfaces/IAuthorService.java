package com.example.booklibraryspringboot.service.interfaces;

import com.example.booklibraryspringboot.dto.author.AuthorDTO;
import com.example.booklibraryspringboot.repository.AuthorRepository;

import java.util.List;

public interface IAuthorService {
    AuthorDTO create(AuthorDTO author);

    AuthorDTO update(AuthorDTO author, Long id);

    AuthorDTO getById(Long id);

    List<AuthorDTO> getList();

    Boolean delete(Long id);


}
