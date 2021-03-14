package com.example.bug_report.controller.admin;

import com.example.bug_report.entity.User;
import com.example.bug_report.model.request.UpdateUserReq;
import com.example.bug_report.service.IRoleService;
import com.example.bug_report.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ManagerUserController {
    @Autowired private IUserService userService;
    @Autowired private IRoleService roleService;

    @GetMapping("/admin/user")
    public String getUserManager(Model model, @RequestParam(required = false) Integer page) {
        if (page == null) {
            page = 0;
        } else {
            page--;
            if (page < 0) {
                page = 0;
            }
        }
        Page<User> users = userService.getAllUser(page);
        model.addAttribute("totalPages", users.getTotalPages());
        model.addAttribute("currentPage", ++page);
        model.addAttribute("users", users.getContent());
        return "/admin/user/users";
    }

    @GetMapping("/admin/user/{id}")
    public String showEditPage(Model model, @PathVariable("id") long id, @ModelAttribute("updateUserReq") UpdateUserReq req) {
        User user = userService.findUserById(id);

        req.setRoles(user.getRoles());

        model.addAttribute("roles", roleService.getAll());
        model.addAttribute("user", user);
        return "/admin/user/user_details";
    }

    @PostMapping("/admin/user/save")
    public String editPage(Model model, @RequestParam(required = false) long userId,
                           @ModelAttribute("updateUserReq") UpdateUserReq req) {
        User user = userService.findUserById(userId);
        user.setRoles(req.getRoles());
        userService.save(user);
        return "redirect:/admin/user";
    }

}
