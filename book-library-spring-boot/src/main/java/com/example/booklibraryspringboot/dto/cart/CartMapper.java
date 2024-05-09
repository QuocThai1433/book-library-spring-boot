package com.example.booklibraryspringboot.dto.cart;

import com.example.booklibraryspringboot.dto.cart.CartDTO;
import com.example.booklibraryspringboot.entity.CartEntity;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {
    public CartEntity toEntity(CartDTO dto) {
        return CartEntity.builder()
                .id(dto.getId())
                .quantity(dto.getQuantity())
                .price(dto.getPrice())
                .build();

    }
    public CartEntity toEntity(CartDTO dto,Long id) {
        return CartEntity.builder()
                .id(id)
                .quantity(dto.getQuantity())
                .price(dto.getPrice())
                .build();

    }
    public CartDTO toDTO(CartEntity entity) {
        return CartDTO.builder()
                .id(entity.getId())
                .quantity(entity.getQuantity())
                .price(entity.getPrice())
                .build();
    }
}
