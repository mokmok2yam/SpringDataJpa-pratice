package com.back.domain.post.service;

import com.back.domain.post.entity.Post;
import com.back.domain.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PostService {
    @Autowired
    private PostRepository postRepository;
    public Post write(String title, String content){
        Post post = new Post(title,content);
        return postRepository.save(post);
    }
    public Optional<Post> findById(int id){
        return postRepository.findById(id);
    }
    public List<Post> findAll(){
        return postRepository.findAll();
    }
    public long count(){
        return postRepository.count();
    }
}
