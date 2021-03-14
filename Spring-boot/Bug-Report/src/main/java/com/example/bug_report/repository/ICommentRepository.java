package com.example.bug_report.repository;

import com.example.bug_report.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findCommentsByPostId(long id);
    Comment save(Comment comment);
}
