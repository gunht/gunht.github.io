package com.example.bug_report.repository;

import com.example.bug_report.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStatusRepository extends JpaRepository<Status, Integer> {
    Status findById(int statusId);
}
