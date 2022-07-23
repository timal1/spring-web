package com.timal1.spring.web.auth.converters;

import com.timal1.spring.web.api.dto.UserDto;
import com.timal1.spring.web.auth.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User dtoToEntity(UserDto userDto) {
        return new User(userDto.getId(), userDto.getUsername());
    }

    public UserDto entityToDto(User user) {
        return new UserDto(user.getId(), user.getUsername());
    }


}
