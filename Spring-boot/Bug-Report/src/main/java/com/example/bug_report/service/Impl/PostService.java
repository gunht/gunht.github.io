package com.example.bug_report.service.Impl;

import com.example.bug_report.entity.Post;
import com.example.bug_report.entity.User;
import com.example.bug_report.model.request.CreatePostReq;
import com.example.bug_report.repository.IPostRepository;
import com.example.bug_report.service.IPostService;
import com.example.bug_report.service.IStatusService;
import org.hibernate.CacheMode;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.massindexing.MassIndexer;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.List;

import static com.example.bug_report.config.Constant.STATUS_NOT_FIXED;

@Service
public class PostService implements IPostService {
    @Autowired private IPostRepository postRepository;
    @Autowired private IStatusService statusService;
    @Autowired private EntityManager entityManager;

    @Override
    public Page<Post> getListPost(int page) {
        return postRepository.findAll(PageRequest.of(page, 10, Sort.by("createdAt").descending().and(Sort.by("id").descending())));
    }

    @Override
    public Post getPostById(long id) {
        return postRepository.findPostById(id);
    }

    @Override
    public void removePost(long id) {
        postRepository.delete(getPostById(id));
    }

    @Override
    public List<Post> searchPost(String terms, int limit, int offset) {
        return Search.session(entityManager).search(Post.class).where(f -> f.match().fields("title", "content")
                .matching(terms)).fetchHits(offset, limit);
    }

    @Override
    public void reindexFullText() {
        SearchSession searchSession = Search.session(entityManager);

        MassIndexer indexer = searchSession.massIndexer(Post.class).dropAndCreateSchemaOnStart(true)
                .typesToIndexInParallel(2)
                .batchSizeToLoadObjects(10)
                .idFetchSize(200)
                .threadsToLoadObjects(5)
                .cacheMode(CacheMode.IGNORE);
        indexer.start();
    }

    @Override
    public Post createPost(CreatePostReq req, User user) {
        Post post = new Post();

        post.setTitle(req.getTitle());
        post.setContent(req.getContent());
        post.setCreatedBy(user);
        post.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        post.setStatus(statusService.getStatusById(STATUS_NOT_FIXED));

        if (req.getImage1() == null) {
            post.setImage1("no-image.png");
        } else {
            post.setImage1(req.getImage1());
        }
        if (req.getImage2() == null) {
            post.setImage2("no-image.png");
        } else {
            post.setImage2(req.getImage2());
        }
        if (req.getImage3() == null) {
            post.setImage3("no-image.png");
        } else {
            post.setImage3(req.getImage3());
        }

        postRepository.save(post);
        return post;
    }

    @Override
    public Post updatePost(CreatePostReq req, long id) {
        Post post = postRepository.findPostById(id);

        post.setTitle(req.getTitle());
        post.setContent(req.getContent());
        post.setModifiedAt(new Timestamp(System.currentTimeMillis()));
//        post.setStatus(statusService.getStatusById(req.getStatus()));
        post.setStatus(req.getStatus());

        if (req.getImage1() != null) {
            post.setImage1(req.getImage1());
        }
        if (req.getImage2() != null) {
            post.setImage2(req.getImage2());
        }
        if (req.getImage3() != null) {
            post.setImage3(req.getImage3());
        }

        postRepository.save(post);
        return post;
    }


}
