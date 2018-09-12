package com.blog.blog;

import com.blog.blog.models.Post;
import com.blog.blog.repositories.UserRepo;
import com.blog.blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private final PostService postService;
    private UserRepo userDao;

    public PostController(PostService postService, UserRepo userDao) {
        this.postService = postService;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String getAllPost(Model model) {
        List<Post> allPosts = postService.findAll();
        model.addAttribute("allPosts", allPosts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewById(@PathVariable long id, Model model) {
        Post post = postService.findOne(id);
        model.addAttribute("post", post);
        return "posts/show";
    }


    @GetMapping("/posts/create")
    public String createForm(Model model) {
        Post emptyPost = new Post();
        model.addAttribute("post", emptyPost);
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPosts(@ModelAttribute Post post) {
        post.setUser(userDao.findOne(1L));
        postService.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String viewEditPosts(@PathVariable long id, Model model) {
        Post post = postService.findOne(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }


    @PostMapping("/posts/edit")
    public String executeEditPosts(@ModelAttribute Post post) {
        postService.save(post);
        return "redirect:/posts";
    }



    @PostMapping("/posts/delete")
    public String deletePosts(@RequestParam(name = "id") long id) {
        postService.deletePost(id);
        return "redirect:/posts";
    }





}
