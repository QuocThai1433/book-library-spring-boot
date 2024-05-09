package com.example.booklibraryspringboot.service;

import com.example.booklibraryspringboot.entity.BookEntity;
import com.example.booklibraryspringboot.repository.ExportToExcelRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExportToExcelService {
public final ExportToExcelRepository repository;

    public ExportToExcelService(ExportToExcelRepository repository) {
        this.repository = repository;
    }

    public List<BookEntity> listAll() {
        return repository.findAll();
    }
}
