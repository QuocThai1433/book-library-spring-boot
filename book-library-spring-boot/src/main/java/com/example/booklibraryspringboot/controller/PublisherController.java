package com.example.booklibraryspringboot.controller;

import com.example.booklibraryspringboot.dto.publisher.PublisherDTO;
import com.example.booklibraryspringboot.service.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v1/publisher/")
@RestController

public class PublisherController {
    public final PublisherService service;

    public PublisherController(PublisherService service) {
        this.service = service;

    }

    @PostMapping("create")
    public ResponseEntity<PublisherDTO> create(@RequestBody PublisherDTO author) {
        return ResponseEntity.ok(service.create(author));
    }

    @PutMapping("update")
    public ResponseEntity<PublisherDTO> update(@RequestBody PublisherDTO author, Long id) {
        return ResponseEntity.ok(service.update(author, id));
    }

    @GetMapping("getList")
    public ResponseEntity<List<PublisherDTO>> getList() {
        return ResponseEntity.ok(service.getList());
    }

    @GetMapping("getById")
    public ResponseEntity<PublisherDTO> getById(@RequestParam Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }


}
