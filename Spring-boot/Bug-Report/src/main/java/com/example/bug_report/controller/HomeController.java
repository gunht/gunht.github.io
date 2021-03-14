package com.example.bug_report.controller;

import com.example.bug_report.entity.Post;
import com.example.bug_report.entity.User;
import com.example.bug_report.model.request.SearchReq;
import com.example.bug_report.security.CustomUserDetails;
import com.example.bug_report.service.IPostService;
import com.example.bug_report.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IPostService postService;

    @GetMapping({"/", "/home", "/post"})
    public String getIndex(Model model, @RequestParam(required = false) Integer page) {
        if (page == null) {
            page = 0;
        } else {
            page--;
            if (page < 0) {
                page = 0;
            }
        }
        Page<Post> posts = postService.getListPost(page);

        model.addAttribute("totalPages", posts.getTotalPages());
        model.addAttribute("currentPage", ++page);
        model.addAttribute("posts", posts.getContent());
        model.addAttribute("searchReq", new SearchReq());
        return "index";
    }


}
