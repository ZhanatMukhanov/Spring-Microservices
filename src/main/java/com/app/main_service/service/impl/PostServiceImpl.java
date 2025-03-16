package com.app.main_service.service.impl;

import com.app.main_service.model.constants.ApiErrorMessage;
import com.app.main_service.model.dto.post.PostDTO;
import com.app.main_service.model.entities.Post;
import com.app.main_service.model.exception.NotFoundException;
import com.app.main_service.model.response.MainResponse;
import com.app.main_service.repositories.PostRepository;
import com.app.main_service.service.PostService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public MainResponse<PostDTO> getById(@NotNull Integer postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException(ApiErrorMessage.POST_NOT_FOUND_BY_ID.getMessage(postId)));

        PostDTO postDTO = PostDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .created(post.getCreated())
                .likes(post.getLikes())
                .build();

        return MainResponse.createSuccessful(postDTO);
    }
}
