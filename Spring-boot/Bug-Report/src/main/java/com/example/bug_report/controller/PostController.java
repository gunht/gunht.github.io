package com.example.bug_report.controller;

import com.example.bug_report.entity.Post;
import com.example.bug_report.entity.User;
import com.example.bug_report.model.request.CreateCommentReq;
import com.example.bug_report.model.request.CreatePostReq;
import com.example.bug_report.security.CustomUserDetails;
import com.example.bug_report.service.ICommentService;
import com.example.bug_report.service.IPostService;
import com.example.bug_report.service.IStatusService;
import com.example.bug_report.utils.FileUploadManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

@Controller
public class PostController {
    @Autowired private IPostService postService;
    @Autowired private ICommentService commentService;
    @Autowired private IStatusService statusService;
    @Autowired private AuthenticationManager authenticationManager;

    @GetMapping("/create-post")
    public String getCreatePost(@ModelAttribute("createPostReq") CreatePostReq req) {
        return "create_post";
    }

    @PostMapping("/create-post/save")
    public String savePost(@ModelAttribute("createPostReq") CreatePostReq req,
                           @RequestParam("extraImage1") MultipartFile extraImage1,
                           @RequestParam("extraImage2") MultipartFile extraImage2,
                           @RequestParam("extraImage3") MultipartFile extraImage3) throws IOException {
        User user = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();

        String image1 = setImageNameReq(extraImage1, req, 1);
        String image2 = setImageNameReq(extraImage2, req, 2);
        String image3 = setImageNameReq(extraImage3, req, 3);

        Post savedPost = postService.createPost(req, user);

        String uploadDir = "./images/" + savedPost.getId();

        if (image1 != null) {
            FileUploadManager.saveFile(uploadDir, extraImage1, image1);
        }
        if (image2 != null) {
            FileUploadManager.saveFile(uploadDir, extraImage2, image2);
        }
        if (image3 != null) {
            FileUploadManager.saveFile(uploadDir, extraImage3, image3);
        }

        return "redirect:/";
    }

    @GetMapping("/post/{id}")
    public String getPage(Model model, @PathVariable long id, @ModelAttribute("commentReq") CreateCommentReq req) {
        Post post = postService.getPostById(id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ANONYMOUS"))) {
            model.addAttribute("user", ((CustomUserDetails)SecurityContextHolder.getContext().getAuthentication()
                    .getPrincipal()).getUser());
        }
        model.addAttribute("post", post);
        return "post";
    }

    @GetMapping("/post/edit")
    public String getUpdatePost(Model model, @RequestParam(required = false) Long id) {
        Post post = postService.getPostById(id);

        CreatePostReq req = new CreatePostReq();
        req.setTitle(post.getTitle());
        req.setContent(post.getContent());
        req.setImage1(post.getImage1());
        req.setImage2(post.getImage2());
        req.setImage3(post.getImage3());
        req.setStatus(post.getStatus());

        req.setPrImage1(post.getExtraImage1());
        req.setPrImage2(post.getExtraImage2());
        req.setPrImage3(post.getExtraImage3());

        model.addAttribute("allStatus", statusService.getAll());
        model.addAttribute("createPostReq", req);
        model.addAttribute("postId", id);
        return "create_post";
    }

    @PostMapping("/create-post/save/{id}")
    public String updatePost(@ModelAttribute("createPostReq") CreatePostReq req,
                             @PathVariable Long id,
                             @RequestParam("extraImage1") MultipartFile extraImage1,
                             @RequestParam("extraImage2") MultipartFile extraImage2,
                             @RequestParam("extraImage3") MultipartFile extraImage3) throws IOException {

        String image1 = setImageNameReq(extraImage1, req, 1);
        String image2 = setImageNameReq(extraImage2, req, 2);
        String image3 = setImageNameReq(extraImage3, req, 3);

        Post savedPost = postService.updatePost(req, id);

        String uploadDir = "./images/" + savedPost.getId();

        if (image1 != null) {
            FileUploadManager.saveFile(uploadDir, extraImage1, image1);
        }
        if (image2 != null) {
            FileUploadManager.saveFile(uploadDir, extraImage2, image2);
        }
        if (image3 != null) {
            FileUploadManager.saveFile(uploadDir, extraImage3, image3);
        }

        return "redirect:/post/" + id;
    }

    @DeleteMapping("/post/remove/{id}")
    public ResponseEntity<?> removePost(@PathVariable long id) {
        postService.removePost(id);
        return ResponseEntity.ok("Delete Success!");
    }

    private String setImageNameReq(MultipartFile imageNameReq, CreatePostReq req, int count) {
        if (!Objects.equals(imageNameReq.getOriginalFilename(), "")) {
            String name = StringUtils.cleanPath(Objects.requireNonNull(imageNameReq.getOriginalFilename()));
            switch (count) {
                case 1 -> req.setImage1(name);
                case 2 -> req.setImage2(name);
                case 3 -> req.setImage3(name);
            }
            return name;
        }
        return null;
    }
}
