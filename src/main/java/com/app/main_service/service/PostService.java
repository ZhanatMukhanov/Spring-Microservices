package com.app.main_service.service;

import com.app.main_service.model.dto.post.PostDTO;
import com.app.main_service.model.dto.post.PostSearchDTO;
import com.app.main_service.model.request.post.PostRequest;
import com.app.main_service.model.request.post.UpdatePostRequest;
import com.app.main_service.model.response.MainResponse;
import com.app.main_service.model.response.PaginationResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Pageable;

public interface PostService {

    MainResponse<PostDTO> getById(@NotNull Integer postId);

    MainResponse<PostDTO> createPost(@NotNull PostRequest postRequest);

    MainResponse<PostDTO> updatePost(@NotNull Integer postId, @NotNull UpdatePostRequest postRequest);

    void softDeletePost(Integer postId);

    MainResponse<PaginationResponse<PostSearchDTO>> findAllPosts(Pageable pageable);

}
