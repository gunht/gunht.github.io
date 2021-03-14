package com.example.bug_report.model.request;

import com.example.bug_report.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserReq {
    private String fullName;
    private String email;
    private List<Role> roles = new ArrayList<>();
}
