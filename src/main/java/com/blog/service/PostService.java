package com.blog.service;

import com.blog.dto.PostRequest;
import com.blog.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    public List<Post> getPosts();

    public Optional<Post> getPost(Long id);

    public Post createPost(PostRequest post) throws Exception;

    public Post updatePost(PostRequest post, Long id) throws Exception;


    public Post deletePost(Long id) throws Exception;

}
