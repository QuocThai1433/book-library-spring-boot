package com.example.booklibraryspringboot.controller;

import com.example.booklibraryspringboot.dto.book.BookStatisticsRequest;
import com.example.booklibraryspringboot.dto.category.CategoryDTO;
import com.example.booklibraryspringboot.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/category/")
@RestController

public class CategoryController {
    public final CategoryService service ;

    public CategoryController(CategoryService service  ) {
        this.service = service;

    }

    @PostMapping("create")
    public ResponseEntity<CategoryDTO> create(@RequestBody CategoryDTO author) {
        return ResponseEntity.ok(service.create(author));
    }

    @PutMapping("update")
    public ResponseEntity<CategoryDTO> update(@RequestBody CategoryDTO author,Long id) {
        return ResponseEntity.ok(service.update(author,id));
    }

    @GetMapping("getList")
    public ResponseEntity<List<CategoryDTO>> getList() {
        return ResponseEntity.ok(service.getList());
    }

    @GetMapping("getById")
    public ResponseEntity<CategoryDTO> getById(@RequestParam Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }


}
