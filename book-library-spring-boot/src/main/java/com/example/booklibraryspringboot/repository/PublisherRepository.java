package com.example.booklibraryspringboot.repository;

import com.example.booklibraryspringboot.entity.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<PublisherEntity,Long> {
}
