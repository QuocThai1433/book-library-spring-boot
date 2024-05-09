package com.example.booklibraryspringboot.controller;

import com.example.booklibraryspringboot.dto.cart.CartDTO;
import com.example.booklibraryspringboot.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/cart/")
@RestController

public class CartController {
    public final CartService service;

    public CartController(CartService service) {
        this.service = service;

    }

    @PostMapping("create")
    public ResponseEntity<CartDTO> create(@RequestBody CartDTO cart) {
        return ResponseEntity.ok(service.create(cart));
    }

    @PutMapping("update")
    public ResponseEntity<CartDTO> update(@RequestBody CartDTO cart, Long id) {
        return ResponseEntity.ok(service.update(cart, id));
    }

    @GetMapping("getList")
    public ResponseEntity<List<CartDTO>> getList() {
        return ResponseEntity.ok(service.getList());
    }

    @GetMapping("getById")
    public ResponseEntity<CartDTO> getById(@RequestParam Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
