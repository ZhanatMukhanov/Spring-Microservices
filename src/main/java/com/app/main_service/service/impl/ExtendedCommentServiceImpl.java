package com.app.main_service.service.impl;

import com.app.main_service.service.CommentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExtendedCommentServiceImpl implements CommentService {

    private final List<String> comments = new ArrayList<>();

    public List<String> getComments() {
        return comments;
    }

    @Override
    public void createComment(String comment) {
        String formattedComment = String.format("[%s] %s", LocalDateTime.now(), comment.toUpperCase());

        comments.add(formattedComment);

        System.out.printf("Extended comment added: %s%n", formattedComment);
    }
}
