package com.example.booklibraryspringboot.controller;

import com.example.booklibraryspringboot.dto.reader.ReaderDTO;
import com.example.booklibraryspringboot.service.ReaderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v1/reader/")
@RestController

public class ReaderController
{
    public final ReaderService service;

    public ReaderController
            (ReaderService service) {
        this.service = service;

    }

    @PostMapping("create")
    public ResponseEntity<ReaderDTO> create(@RequestBody ReaderDTO author) {
        return ResponseEntity.ok(service.create(author));
    }

    @PutMapping("update")
    public ResponseEntity<ReaderDTO> update(@RequestBody ReaderDTO author, Long id) {
        return ResponseEntity.ok(service.update(author, id));
    }

    @GetMapping("getList")
    public ResponseEntity<List<ReaderDTO>> getList() {
        return ResponseEntity.ok(service.getList());
    }

    @GetMapping("getById")
    public ResponseEntity<ReaderDTO> getById(@RequestParam Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }



}
