package me.sahar.blog.services;

import me.sahar.blog.entities.Post;
import me.sahar.blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts(){
      return postRepository.findAll();
    }

    public void insert(Post post) {
        postRepository.save(post);
    }
}
