package com.blog.blog.services;

import com.blog.blog.models.Post;
import com.blog.blog.repositories.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    PostRepository PostDao;

    public PostService(PostRepository postDao) {
        PostDao = postDao;
    }

    public List<Post> findAll() {
        return PostDao.findAll();

    }

    public void save(Post post) {
        PostDao.save(post);
    }

    public Post findOne(long id) {
        return PostDao.findOne(id);
    }

    public void deletePost(long id) {
        PostDao.delete(id);
    }

    public void editPost(Post post) {
        PostDao.save(post);
}






}
