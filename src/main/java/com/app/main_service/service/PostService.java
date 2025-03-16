package com.app.main_service.service;

import com.app.main_service.model.dto.post.PostDTO;
import com.app.main_service.model.response.MainResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    MainResponse<PostDTO> getById(@NotNull Integer postId);
}
