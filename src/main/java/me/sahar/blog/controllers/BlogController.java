package me.sahar.blog.controllers;

import me.sahar.blog.entities.Post;
import me.sahar.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private PostService postService;

    @GetMapping  ( value = "/")
    public String Index() {
        return "Index";
    }

    @GetMapping  ( value = "/posts")
    public List<Post> Posts() {
        return postService.getAllPosts();
    }

    @GetMapping  ( value = "/post")
    public void PublishPost(@RequestBody Post post) {
        if (post.getCreatedDate() == null)
            post.setCreatedDate(new Date() );
          postService.insert(post);
    }

}