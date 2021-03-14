package com.example.bug_report.service.Impl;

import com.example.bug_report.entity.Comment;
import com.example.bug_report.entity.Post;
import com.example.bug_report.entity.User;
import com.example.bug_report.model.request.CreateCommentReq;
import com.example.bug_report.repository.ICommentRepository;
import com.example.bug_report.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CommentService implements ICommentService {
    @Autowired private ICommentRepository commentRepository;

    @Override
    public List<Comment> getCommentsByPost(long id) {
        return commentRepository.findCommentsByPostId(id);
    }

    @Override
    public Comment saveComment(CreateCommentReq req, Post post, User user) {
        Comment comment = new Comment();

        comment.setContent(req.getContent());
        comment.setCommenter(user);
        comment.setPost(post);
        comment.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        return commentRepository.save(comment);
    }


}
