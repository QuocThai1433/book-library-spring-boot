package com.example.booklibraryspringboot.repository;

import com.example.booklibraryspringboot.entity.BookReaderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookReaderRepository extends JpaRepository<BookReaderEntity,Long> {
}
