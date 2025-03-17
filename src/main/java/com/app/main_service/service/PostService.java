package com.app.main_service.service;

import com.app.main_service.model.dto.post.PostDTO;
import com.app.main_service.model.request.post.PostRequest;
import com.app.main_service.model.request.post.UpdatePostRequest;
import com.app.main_service.model.response.MainResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    MainResponse<PostDTO> getById(@NotNull Integer postId);

    MainResponse<PostDTO> createPost(@NotNull PostRequest postRequest);

    MainResponse<PostDTO> updatePost(@NotNull Integer postId, @NotNull UpdatePostRequest postRequest);

    void softDeletePost(Integer postId);
}
