package com.example.booklibraryspringboot.service.interfaces;

import com.example.booklibraryspringboot.dto.rating.RatingDTO;

import java.util.List;

public interface IRatingService {
    RatingDTO create(RatingDTO author);

    RatingDTO update(RatingDTO author, Long id);

    RatingDTO getById(Long id);

    List<RatingDTO> getList();

    Boolean delete(Long id);
}
