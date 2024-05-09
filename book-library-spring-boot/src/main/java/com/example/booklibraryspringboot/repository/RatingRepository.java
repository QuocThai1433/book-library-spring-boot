package com.example.booklibraryspringboot.repository;

import com.example.booklibraryspringboot.entity.RatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.beans.JavaBean;
@Repository
public interface RatingRepository extends JpaRepository<RatingEntity,Long> {
}
