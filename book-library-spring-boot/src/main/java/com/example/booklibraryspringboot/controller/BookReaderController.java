package com.example.booklibraryspringboot.controller;

import com.example.booklibraryspringboot.dto.book_reader.BookReaderDTO;
import com.example.booklibraryspringboot.dto.book.BookStatisticsRequest;
import com.example.booklibraryspringboot.dto.book.FilterBookRequest;
import com.example.booklibraryspringboot.service.BookReaderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RequestMapping("/api/v1/book-reader/")
@RestController
public class BookReaderController {
    public final BookReaderService service;

    public BookReaderController(BookReaderService service) {
        this.service = service;

    }

    @PostMapping("create")
    public ResponseEntity<BookReaderDTO> create(@RequestBody BookReaderDTO book) {
        return ResponseEntity.ok(service.create(book));
    }

    @PutMapping("update")
    public ResponseEntity<BookReaderDTO> update(@RequestBody BookReaderDTO book, @RequestParam Long id) {
        return ResponseEntity.ok(service.update(book, id));
    }

    @GetMapping("getList")
    public ResponseEntity<List<BookReaderDTO>> getList() {
        return ResponseEntity.ok(service.getList());
    }

    @GetMapping("getById")
    public ResponseEntity<BookReaderDTO> getById(@RequestParam Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
