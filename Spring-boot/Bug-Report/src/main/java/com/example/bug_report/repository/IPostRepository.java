package com.example.bug_report.repository;

import com.example.bug_report.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends JpaRepository<Post, Long> {
    Page<Post>findAll(Pageable pageable);
    Post findPostById(long id);
}
