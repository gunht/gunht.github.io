package com.example.bug_report.controller;

import com.example.bug_report.entity.Post;
import com.example.bug_report.model.request.SearchReq;
import com.example.bug_report.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SearchController {
    @Autowired private IPostService postService;

    @PostMapping("/search")
    public String handleSearch(@ModelAttribute("searchReq") SearchReq req, Model model) {
        List<Post> posts = postService.searchPost(req.getTerm(), 10, 0);
        model.addAttribute("posts", posts);
        return "search";
    }

    @GetMapping("/search/index")
    public String reindexFullText() {
        postService.reindexFullText();
        return "redirect:/";
    }
}
