package com.app.main_service.controller;

import com.app.main_service.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createPost(@RequestBody Map<String, Object> requestBody) {
        String title = (String) requestBody.get("title");
        String content = (String) requestBody.get("content");

        String postContent = String.format("Title: %s%n%nContent: %s", title, content);

        postService.createPost(postContent);

        return new ResponseEntity<>(String.format("Post %s created successfully", title), HttpStatus.OK);
    }
}

