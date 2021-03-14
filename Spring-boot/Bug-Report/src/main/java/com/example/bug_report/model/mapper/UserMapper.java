package com.example.bug_report.model.mapper;

import com.example.bug_report.entity.Role;
import com.example.bug_report.entity.User;
import com.example.bug_report.model.request.CreateUserReq;
import com.example.bug_report.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public static User toUser(CreateUserReq req, List<Role> roles) {
        User user = new User();

        user.setFullName(req.getFullName());
        user.setEmail(req.getEmail());
        String hash = BCrypt.hashpw(req.getPassword(), BCrypt.gensalt());
        user.setPassword(hash);
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        user.setStatus(true);
        user.setRoles(roles);

        return user;
    }
}
