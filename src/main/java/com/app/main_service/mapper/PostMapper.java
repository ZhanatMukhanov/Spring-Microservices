package com.app.main_service.mapper;

import com.app.main_service.model.dto.post.PostDTO;
import com.app.main_service.model.dto.post.PostSearchDTO;
import com.app.main_service.model.entities.Post;
import com.app.main_service.model.request.post.PostRequest;
import com.app.main_service.model.request.post.UpdatePostRequest;
import jakarta.validation.constraints.NotNull;
import org.hibernate.type.descriptor.DateTimeUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        imports = {DateTimeUtils.class, Object.class}
)
public interface PostMapper {

    PostDTO toPostDTO(Post post);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    Post createPost(PostRequest postRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    void updatePost(@MappingTarget Post post, UpdatePostRequest postRequest);

    @Mapping(source = "deleted", target = "deleted")
    PostSearchDTO toPostSearchDTO(Post post);
}
