package com.app.main_service.model.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDTO implements Serializable {

    private int id;
    private String title;
    private String content;
    private LocalDateTime created;
    private int likes;

}
