package com.app.main_service.service.impl;

import com.app.main_service.mapper.PostMapper;
import com.app.main_service.model.constants.ApiErrorMessage;
import com.app.main_service.model.dto.post.PostDTO;
import com.app.main_service.model.entities.Post;
import com.app.main_service.model.exception.DataExistsException;
import com.app.main_service.model.exception.NotFoundException;
import com.app.main_service.model.request.post.PostRequest;
import com.app.main_service.model.response.MainResponse;
import com.app.main_service.repositories.PostRepository;
import com.app.main_service.service.PostService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public MainResponse<PostDTO> getById(@NotNull Integer postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException(ApiErrorMessage.POST_NOT_FOUND_BY_ID.getMessage(postId)));

        PostDTO postDto = postMapper.toPostDTO(post);

        return MainResponse.createSuccessful(postDto);

    }

    @Override
    public MainResponse<PostDTO> createPost(@NotNull PostRequest postRequest) {

        if(postRepository.existsByTitle(postRequest.getTitle())){
            throw new DataExistsException(ApiErrorMessage.POST_ALREADY_EXISTS.getMessage(postRequest.getTitle()));
        }

        Post post = postMapper.createPost(postRequest);
        Post savedPost = postRepository.save(post);
        PostDTO postDto = postMapper.toPostDTO(savedPost);

        return MainResponse.createSuccessful(postDto);
    }


}
