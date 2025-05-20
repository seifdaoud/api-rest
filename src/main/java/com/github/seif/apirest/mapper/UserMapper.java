package com.github.seif.apirest.mapper;

import com.github.seif.apirest.dto.UserDto;
import com.github.seif.apirest.entity.User;

public class UserMapper {

    public static UserDto toDto(User u) {
        return new UserDto(u.getId(), u.getName(), u.getEmail());
    }

    public static User toEntity(UserDto d) {
        User u = new User();
        u.setName(d.name());
        u.setEmail(d.email());
        return u;
    }

    public static void updateEntity(User u, UserDto d) {
        if (d.name()  != null) u.setName(d.name());
        if (d.email() != null) u.setEmail(d.email());
    }
}
