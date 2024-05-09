package com.example.booklibraryspringboot.controller;

import com.example.booklibraryspringboot.dto.author.AuthorDTO;
import com.example.booklibraryspringboot.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/author/")
@RestController

public class AuthorController {
    public final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;

    }

    @PostMapping("create")
    public ResponseEntity<AuthorDTO> create(@RequestBody AuthorDTO author) {
        return ResponseEntity.ok(service.create(author));
    }

    @PutMapping("update")
    public ResponseEntity<AuthorDTO> update(@RequestBody AuthorDTO author, Long id) {
        return ResponseEntity.ok(service.update(author, id));
    }

    @GetMapping("getList")
    public ResponseEntity<List<AuthorDTO>> getList() {
        return ResponseEntity.ok(service.getList());
    }

    @GetMapping("getById")
    public ResponseEntity<AuthorDTO> getById(@RequestParam Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("delete")
    public ResponseEntity<AuthorDTO> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

}
