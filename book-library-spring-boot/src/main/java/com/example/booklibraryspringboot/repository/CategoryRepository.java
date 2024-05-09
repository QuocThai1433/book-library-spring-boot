package com.example.booklibraryspringboot.repository;

import com.example.booklibraryspringboot.dto.book.BookStatisticsRequest;
import com.example.booklibraryspringboot.entity.CartEntity;
import com.example.booklibraryspringboot.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {

}
