package com.example.booklibraryspringboot.service.interfaces;

import com.example.booklibraryspringboot.dto.cart.CartDTO;

import java.util.List;

public interface ICartService {
    CartDTO create(CartDTO author);

    CartDTO update(CartDTO author, Long id);

    CartDTO getById(Long id);

    List<CartDTO> getList();

    Boolean delete(Long id);
}
