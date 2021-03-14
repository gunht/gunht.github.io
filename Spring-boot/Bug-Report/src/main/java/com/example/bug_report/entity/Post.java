package com.example.bug_report.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posts")
@Indexed
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @FullTextField
    @Column(name = "title", nullable = false, length = 300)
    private String title;

    @FullTextField
    @Column(name = "content", nullable = false, length = 5000)
    private String content;

    private String image1;
    private String image2;
    private String image3;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "modified_at")
    private Timestamp modifiedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private User createdBy;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "post_id")
    private List<Comment> comments = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Status status;

    @Transient
    public String getExtraImage1() {
        return "/images/" + id + "/" + image1;
    }

    @Transient
    public String getExtraImage2() {
        return "/images/" + id + "/" + image2;
    }

    @Transient
    public String getExtraImage3() {
        return "/images/" + id + "/" + image3;
    }
}
