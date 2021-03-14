package com.example.bug_report.controller;

import com.example.bug_report.entity.Post;
import com.example.bug_report.entity.User;
import com.example.bug_report.model.request.CreateCommentReq;
import com.example.bug_report.repository.ICommentRepository;
import com.example.bug_report.security.CustomUserDetails;
import com.example.bug_report.service.ICommentService;
import com.example.bug_report.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {
    @Autowired private ICommentService commentService;
    @Autowired private IPostService postService;

    @PostMapping("/post/{postId}/save-comment")
    public String saveComment(@PathVariable("postId") long postId, @ModelAttribute("commentReq") CreateCommentReq req) {
        User user = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
        Post post = postService.getPostById(postId);
        commentService.saveComment(req, post, user);
        return "redirect:/post/" + postId;
    }
}
