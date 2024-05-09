package com.example.booklibraryspringboot.service;

import com.example.booklibraryspringboot.dto.cart.CartDTO;
import com.example.booklibraryspringboot.dto.cart.CartMapper;
import com.example.booklibraryspringboot.entity.CartEntity;
import com.example.booklibraryspringboot.repository.CartRepository;
import com.example.booklibraryspringboot.service.interfaces.ICartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class CartService implements ICartService {
    public final CartRepository repository;
    public final CartMapper mapper;
    public CartService(CartRepository repository, CartMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CartDTO create(CartDTO dto) {
        CartEntity entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public CartDTO update(CartDTO dto, Long id) {
        CartEntity entity = mapper.toEntity(dto,id);
        if (getById(id) == null) {
            return null;
        } else
            return mapper.toDTO(repository.save(entity));
    }

    @Override
    public CartDTO getById(Long id) {
        return this.repository.findById(id)
                .map(this.mapper::toDTO)
                .orElseThrow(
                        () -> new RuntimeException("Movie not found")
                );
    }

    @Override
    public List<CartDTO> getList() {

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
