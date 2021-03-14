package com.example.bug_report.model.request;

import com.example.bug_report.entity.Post;
import com.example.bug_report.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCommentReq {
    private String content;

    private Post post;

    private User commenter;
}
