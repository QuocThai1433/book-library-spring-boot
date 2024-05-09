package com.example.booklibraryspringboot.controller;

import com.example.booklibraryspringboot.dto.rating.RatingDTO;
import com.example.booklibraryspringboot.service.RatingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v1/rating/")
@RestController

public class RatingController {
    public final RatingService service;

    public RatingController(RatingService service) {
        this.service = service;

    }

    @PostMapping("create")
    public ResponseEntity<RatingDTO> create(@RequestBody RatingDTO author) {
        return ResponseEntity.ok(service.create(author));
    }

    @PutMapping("update")
    public ResponseEntity<RatingDTO> update(@RequestBody RatingDTO author, Long id) {
        return ResponseEntity.ok(service.update(author, id));
    }

    @GetMapping("getList")
    public ResponseEntity<List<RatingDTO>> getList() {
        return ResponseEntity.ok(service.getList());
    }

    @GetMapping("getById")
    public ResponseEntity<RatingDTO> getById(@RequestParam Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }


}
