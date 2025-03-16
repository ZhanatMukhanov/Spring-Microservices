package com.app.main_service.model.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApiLogMessage {
    POST_INFO_BY_ID("Receiving post with id: %s"),
    POST_CREATED("Post created: %s");

    private final String message;

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
