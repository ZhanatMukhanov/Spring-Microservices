package com.app.main_service.model.request.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePostRequest implements Serializable {

    @NotBlank(message = "Title can't be empty!")
    private String title;
    @NotBlank(message = "Content can't be empty!")
    private String content;
    @NotNull(message = "Likes can't be empty!")
    private Integer likes;

}
