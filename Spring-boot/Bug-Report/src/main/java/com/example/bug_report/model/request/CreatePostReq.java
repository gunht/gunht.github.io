package com.example.bug_report.model.request;

import com.example.bug_report.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Transient;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePostReq {
    private String title;
    private String content;
    private Status status;

    private String image1;
    private String image2;
    private String image3;

    private String prImage1;
    private String prImage2;
    private String prImage3;
}
