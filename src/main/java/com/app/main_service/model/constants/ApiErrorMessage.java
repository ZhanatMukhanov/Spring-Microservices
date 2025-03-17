package com.app.main_service.model.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApiErrorMessage {
    POST_NOT_FOUND_BY_ID("Post with ID: %s not found!"),
    POST_ALREADY_EXISTS("Post with title: %s already exists!"),
    ;

    private final String message;

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
