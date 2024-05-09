package com.example.booklibraryspringboot.repository;

import com.example.booklibraryspringboot.dto.book.BookStatisticsRequest;
import com.example.booklibraryspringboot.dto.book.TotalBookRequest;
import com.example.booklibraryspringboot.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    @Query(value = "SELECT * FROM book b left join author a on a.id = b.author_id left join category c on b.category_id =c.id WHERE c.category_name LIKE :search  OR b.book_name LIKE :search or a.author_name like :search", nativeQuery = true)
    List<BookEntity> filter(@Param("search") String search);

    @Query(value = """
            select b.book_name ,c.category_name ,count(b.id) as total
                       from book b 
                       INNER JOIN category c 
                       ON b.category_id = c.id 
                       group by b.book_name,c.category_name
            """, nativeQuery = true)
    Set<Map<String,BookStatisticsRequest>> bookStatistics();
    // thêm native là hết lõi á a, đây là JPQL, đúng rồi a, em đang test nó mà, xem sự khác biệt
    @Query(value= "SELECT SUM(b.quantity) FROM BookEntity b")
    Double totalBook();
}