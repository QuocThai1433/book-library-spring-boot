package com.example.booklibraryspringboot.service.interfaces;

import com.example.booklibraryspringboot.dto.publisher.PublisherDTO;

import java.util.List;

public interface IPublisherService {
    PublisherDTO create(PublisherDTO author);

    PublisherDTO update(PublisherDTO author, Long id);

    PublisherDTO getById(Long id);

    List<PublisherDTO> getList();

    Boolean delete(Long id);
}
