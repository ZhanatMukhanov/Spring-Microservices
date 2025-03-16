package com.app.main_service.service.impl;

import com.app.main_service.mapper.PostMapper;
import com.app.main_service.model.constants.ApiErrorMessage;
import com.app.main_service.model.dto.post.PostDTO;
import com.app.main_service.model.entities.Post;
import com.app.main_service.model.exception.NotFoundException;
import com.app.main_service.model.response.MainResponse;
import com.app.main_service.repositories.PostRepository;
import com.app.main_service.service.PostService;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public PostServiceImpl(PostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    @Override
    public MainResponse<PostDTO> getById(@NotNull Integer postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException(ApiErrorMessage.POST_NOT_FOUND_BY_ID.getMessage(postId)));

        PostDTO postDto = postMapper.toPostDTO(post);

        return MainResponse.createSuccessful(postDto);

    }
}
