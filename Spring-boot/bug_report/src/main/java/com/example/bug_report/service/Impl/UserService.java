package com.example.bug_report.service.Impl;

import com.example.bug_report.entity.Role;
import com.example.bug_report.entity.User;
import com.example.bug_report.exception.DuplicateRecordException;
import com.example.bug_report.model.mapper.UserMapper;
import com.example.bug_report.model.request.CreateUserReq;
import com.example.bug_report.repository.IUserRepository;
import com.example.bug_report.service.IRoleService;
import com.example.bug_report.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public Page<User> getAllUser(int page) {
        return userRepository.findAll(PageRequest.of(page, 7, Sort.by("createdAt").descending().and(Sort.by("id").descending())));
    }

    @Override
    public User findUserById(long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public User createUser(CreateUserReq req, List<Role> roles) {
        User user = userRepository.getUserByEmail(req.getEmail());
        if (user != null) {
            throw new DuplicateRecordException("Email has exist!");
        }
        user = UserMapper.toUser(req, roles);
        userRepository.save(user);
        return user;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
