package com.back.domain.post.service;

import com.back.domain.post.entity.Post;
import com.back.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor// @Component랑 같은 기능
public class PostService {

    private final PostRepository postRepository;

    public Post write(int authorId, String title, String content) {

        Post post = new Post(authorId, title, content);
        return postRepository.save(post);
    }

    @Transactional
    public Post modify(Post post, String newTitle, String newContent) {
        post.setTitle(newTitle);
        post.setContent(newContent);
//        return postRepository.save(post);
        return post;
    }

    public Optional<Post> findById(int id) {
        return postRepository.findById(id);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public long count() {
        return postRepository.count();
    }

}
