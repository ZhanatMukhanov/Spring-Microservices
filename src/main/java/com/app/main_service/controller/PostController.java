package com.app.main_service.controller;

import com.app.main_service.model.constants.ApiLogMessage;
import com.app.main_service.model.dto.post.PostDTO;
import com.app.main_service.model.request.post.PostRequest;
import com.app.main_service.model.response.MainResponse;
import com.app.main_service.service.PostService;
import com.app.main_service.utils.ApiUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("${end.points.posts}")
public class PostController {

    private final PostService postService;

    @GetMapping("${end.points.id}")
    public ResponseEntity<MainResponse<PostDTO>> getPostById(
            @PathVariable(name = "id") Integer postId) {

        log.trace(ApiLogMessage.NAME_OF_CURRENT_METHOD.getValue(), ApiUtils.getMethodName());

        MainResponse<PostDTO> response = postService.getById(postId);

        return ResponseEntity.ok(response);

    }

    @PostMapping("${end.points.create}")
    public ResponseEntity<MainResponse<PostDTO>> createPost(@RequestBody PostRequest postRequest) {
        log.trace(ApiLogMessage.NAME_OF_CURRENT_METHOD.getValue(), ApiUtils.getMethodName());

        MainResponse<PostDTO> response = postService.createPost(postRequest);

        return ResponseEntity.ok(response);
    }
}

