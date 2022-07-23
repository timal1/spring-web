package com.timal1.spring.web.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Модель Токена")
public class JwtResponse {

    @Schema(description = "токен", required = true, example = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJOYXVjaGtpIiwiRW1haWwiOiJ0aW1hbDFAbWFpbC5ydSIsInJvbGVzIjpbIkFETUlOIl0sImV4cCI6MTY1ODQxNDI0NX0.a37xUEd7UPai7RFXpxWW3TlS6nETcwDvrgm26IFCs4M")
    private String token;
}
