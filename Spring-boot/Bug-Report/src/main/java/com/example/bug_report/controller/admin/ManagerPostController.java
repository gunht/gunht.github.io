package com.example.bug_report.controller.admin;

import com.example.bug_report.entity.Post;
import com.example.bug_report.model.request.CreatePostReq;
import com.example.bug_report.service.IPostService;
import com.example.bug_report.service.IStatusService;
import com.example.bug_report.utils.FileUploadManager;
import com.example.bug_report.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@Controller
public class ManagerPostController {
    @Autowired private IPostService postService;
    @Autowired private IStatusService statusService;
    private final PageUtil pageUtil = new PageUtil();

    @GetMapping("/admin/posts")
    public String getManagerPosts(Model model, @RequestParam(required = false) Integer page) {
        page = pageUtil.getPage(page);

        Page<Post> posts = postService.getListPost(page);

        model.addAttribute("totalPages", posts.getTotalPages());
        model.addAttribute("currentPage", ++page);
        model.addAttribute("posts", posts.getContent());
        return "/admin/blog/posts";
    }

    @GetMapping("/admin/posts/edit/{id}")
    public String getAdminEditPost(Model model, @PathVariable Long id) {
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
        return "/admin/blog/edit";
    }

    @PostMapping("/admin/posts/save/{id}")
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

        return "redirect:/admin/posts";
    }

    @DeleteMapping("/admin/posts/remove/{id}")
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
