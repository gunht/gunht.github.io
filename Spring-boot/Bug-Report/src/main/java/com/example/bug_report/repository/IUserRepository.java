package com.example.bug_report.repository;

import com.example.bug_report.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    Page<User> findAll(Pageable pageable);
    User getUserByEmail(String email);
    User findUserById(long id);
    User save(User user);
}
