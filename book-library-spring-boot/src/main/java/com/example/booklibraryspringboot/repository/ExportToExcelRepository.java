package com.example.booklibraryspringboot.repository;

import com.example.booklibraryspringboot.entity.BookEntity;
import com.example.booklibraryspringboot.service.ExportToExcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExportToExcelRepository extends JpaRepository<BookEntity,Long> {
}
