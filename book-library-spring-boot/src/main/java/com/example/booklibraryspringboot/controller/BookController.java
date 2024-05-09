package com.example.booklibraryspringboot.controller;

import com.example.booklibraryspringboot.dto.book.*;
import com.example.booklibraryspringboot.entity.BookEntity;
import com.example.booklibraryspringboot.service.BookService;
import com.example.booklibraryspringboot.service.ExportToExcel;
import com.example.booklibraryspringboot.service.ExportToExcelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RequestMapping("/api/v1/book/")
@RestController
public class BookController {
    public final BookService service;

    public final ExportToExcelService export;

    public BookController(BookService service, ExportToExcelService export){
        this.service = service;
        this.export = export;

    }

    @PostMapping("create")
    public ResponseEntity<BookDTO> create(@RequestBody BookDTO book) {
        return ResponseEntity.ok(service.create(book));
    }

    @PutMapping("update")
    public ResponseEntity<BookDTO> update(@RequestBody BookDTO book, @RequestParam Long id) {
        return ResponseEntity.ok(service.update(book, id));
    }

    @GetMapping("getList")
    public ResponseEntity<List<BookDTO>> getList() {
        return ResponseEntity.ok(service.getList());
    }

    @GetMapping("getById")
    public ResponseEntity<BookDTO> getById(@RequestParam Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
    @GetMapping("filter")
    public ResponseEntity<List<FilterBookRequest>> filter(@RequestParam String search) {
        return ResponseEntity.ok(service.filter(search));
    }

    @GetMapping("bookStatistics")
    public ResponseEntity<Set<Map<String,BookStatisticsRequest>>> bookStatistics(  ) {
        return ResponseEntity.ok(service.bookStatistics());
    }
    @GetMapping("totalBook")
    public ResponseEntity<Double> totalBook () {
        return ResponseEntity.ok(service.total());
    }

    @GetMapping("api/v1/export-excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<BookEntity> listBookEntitys = export.listAll();

        ExportToExcel excelExporter = new ExportToExcel(listBookEntitys);

        excelExporter.export(response);
    }
}
