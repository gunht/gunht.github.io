package com.example.bug_report.service;

import com.example.bug_report.entity.Post;
import com.example.bug_report.entity.User;
import com.example.bug_report.model.request.CreatePostReq;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IPostService {
    Page<Post> getListPost(int page);
    Post createPost(CreatePostReq req, User user);
    Post updatePost(CreatePostReq req, long id);
    Post getPostById(long id);
    void removePost(long id);
    List<Post> searchPost(String terms, int limit, int offset);
    void reindexFullText();
}
