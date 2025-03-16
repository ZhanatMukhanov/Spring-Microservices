package com.app.main_service.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    public void createPost(String post);

    public List<String> getPosts();
}
