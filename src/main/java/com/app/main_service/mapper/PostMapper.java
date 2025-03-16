package com.app.main_service.mapper;

import com.app.main_service.model.dto.post.PostDTO;
import com.app.main_service.model.entities.Post;
import org.hibernate.type.descriptor.DateTimeUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        imports = {DateTimeUtils.class, Object.class}
)
public interface PostMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "created", target = "created", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    @Mapping(source = "likes", target = "likes")
    PostDTO toPostDTO(Post post);

}
