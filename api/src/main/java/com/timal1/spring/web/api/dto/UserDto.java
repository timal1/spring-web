package com.timal1.spring.web.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String username;
  //  private Collection<Role> roles;

    public UserDto(Long id, String username) {
        this.id = id;
        this.username = username;
    }
}
