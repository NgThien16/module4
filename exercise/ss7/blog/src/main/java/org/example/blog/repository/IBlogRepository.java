package org.example.blog.repository;

import org.example.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog> findByTitleContaining(String title);
    Page<Blog> findByTitleContaining(String title, Pageable pageable);


    @Query(value = "select * from blog where title like :searchTitle", nativeQuery = true)
    List<Blog> timKiemTheoTen(@Param("searchTitle") String title);
}
