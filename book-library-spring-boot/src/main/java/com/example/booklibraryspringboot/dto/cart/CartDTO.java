package com.example.booklibraryspringboot.dto.cart;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class CartDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private int quantity;

    private float price;
}
