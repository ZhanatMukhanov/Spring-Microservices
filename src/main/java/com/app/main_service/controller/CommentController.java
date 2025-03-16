package com.app.main_service.controller;

import com.app.main_service.service.CommentService;
import com.app.main_service.service.impl.CommentServiceImpl;
import com.app.main_service.service.impl.ExtendedCommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService defaultCommentService;
    private final CommentService extendedCommentService;

    @Autowired
    public CommentController(
            CommentService defaultCommentService,
            @Qualifier("extendedCommentService") CommentService extendedCommentService) {
        this.defaultCommentService = defaultCommentService;
        this.extendedCommentService = extendedCommentService;
    }

    @PostMapping("/createDefault")
    public ResponseEntity<String> createDefauiltComment(@RequestBody Map<String, Object> requestBody) {
        String content = (String) requestBody.get("content");
        defaultCommentService.createComment(content);

        return ResponseEntity.ok("Default comment added: " + content);
    }

    @PostMapping("/createExtended")
    public ResponseEntity<String> createExtendedComment(@RequestBody Map<String, Object> requestBody) {
        String content = (String) requestBody.get("content");
        extendedCommentService.createComment(content);

        return ResponseEntity.ok("Extended comment added: " + content);
    }
}
