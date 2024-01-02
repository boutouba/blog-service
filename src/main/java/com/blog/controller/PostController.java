package com.blog.controller;


import com.blog.dto.PostRequest;
import com.blog.entity.Post;
import com.blog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

    public PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(path="/posts", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> getPosts() {
        return new ResponseEntity<>(postService.getPosts(), HttpStatus.OK);
    }

    @RequestMapping(path="/post/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Post>> getPost(@PathVariable Long id) {
        return new ResponseEntity<>(postService.getPost(id), HttpStatus.OK);
    }

    @RequestMapping(path = "/post/add", method = RequestMethod.POST)
    public ResponseEntity<Post> createPost(@RequestBody PostRequest postRequest) throws Exception {
        Post post = postService.createPost(postRequest);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @RequestMapping(path = "/post/edit/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Post> updatePost(@RequestBody PostRequest postRequest, @PathVariable Long id) throws Exception {
        Post post = postService.updatePost(postRequest, id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @RequestMapping(path = "/post/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Post> updatePost(@PathVariable Long id) throws Exception {
        Post post = postService.deletePost(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
}
