package com.app.main_service.model.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApiLogMessage {
    POST_INFO_BY_ID("Receiving post with id: {}"),
    NAME_OF_CURRENT_METHOD("Current method: {}");

    private final String value;

}
