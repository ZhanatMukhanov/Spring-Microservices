package com.app.main_service.service.impl;

import com.app.main_service.service.PostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final List<String> posts = new ArrayList<>();

    @Override
    public void createPost(String post) {
        posts.add(post);
    }

    public List<String> getPosts() {
        return posts;
    }
}
