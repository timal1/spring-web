package com.timal1.spring.web.auth.dto;

import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;
}
