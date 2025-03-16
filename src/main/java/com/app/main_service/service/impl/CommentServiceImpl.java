package com.app.main_service.service.impl;

import com.app.main_service.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final List<String> comments = new ArrayList<>();

    public List<String> getComments() {
        return comments;
    }

    @Override
    public void createComment(String comment) {
        comments.add(comment);
    }
}
