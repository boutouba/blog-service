package com.blog.service.imp;

import com.blog.dto.PostRequest;
import com.blog.entity.Post;
import com.blog.entity.Type;
import com.blog.repository.PostRepository;
import com.blog.repository.TypeRepository;
import com.blog.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    public PostRepository postRepository;
    public TypeRepository typeRepository;

     public PostServiceImpl(PostRepository postRepository, TypeRepository typeRepository) {
         this.postRepository = postRepository;
         this.typeRepository = typeRepository;
     }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPost(Long id) {
         return postRepository.findById(id);
    }

    public Post createPost(PostRequest post) throws Exception {
        Post p = new Post();
        Type t = typeRepository.findById(post.getType()).orElse(null);
        if (t == null) {
            throw new Exception("Post not found");
        }
        p.setTitle(post.getTitle());
        p.setContent(post.getContent());
        p.setType(t);
        postRepository.save(p);
        return p;
    }

    public Post updatePost(PostRequest post, Long id) throws Exception {
        Post p = postRepository.findById(id).orElse(null);
        Type t = typeRepository.findById(post.getType()).orElse(null);
        if (p == null || t == null) {
            throw new Exception("Post not found");
        }
        p.setTitle(post.getTitle());
        p.setContent(post.getContent());
        p.setType(t);
        postRepository.save(p);
        return p;
    }

    public Post deletePost(Long id) throws Exception {
        Post p = postRepository.findById(id).orElse(null);
        if (p == null) {
            throw new Exception("Post not found");
        }
        postRepository.delete(p);
        return p;
    }

}
