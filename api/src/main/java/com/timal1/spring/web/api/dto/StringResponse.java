package com.timal1.spring.web.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Ответ")
public class StringResponse {

    @Schema(description = "Значение UUID", required = true, example = "0566e944-d947-4be4-83ac-1d1d88b7c0dc")
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public StringResponse(String value) {
        this.value = value;
    }

    public StringResponse() {
    }
}
