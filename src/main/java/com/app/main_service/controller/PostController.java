package com.app.main_service.controller;

import com.app.main_service.model.constants.ApiLogMessage;
import com.app.main_service.model.dto.post.PostDTO;
import com.app.main_service.model.response.MainResponse;
import com.app.main_service.service.PostService;
import com.app.main_service.utils.ApiUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("${end.point.posts}")
public class PostController {

    private final PostService postService;

    @GetMapping("${end.point.id}")
    public ResponseEntity<MainResponse<PostDTO>> getPostById(
            @PathVariable(name = "id") Integer postId) {

        log.trace(ApiLogMessage.NAME_OF_CURRENT_METHOD.getValue(), ApiUtils.getMethodName());

        MainResponse<PostDTO> response = postService.getById(postId);

        return ResponseEntity.ok(response);

    }

}

