package com.example.bug_report.repository;

import com.example.bug_report.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    List<Role> findById(long id);
}
