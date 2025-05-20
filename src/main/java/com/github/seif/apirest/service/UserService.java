package com.github.seif.apirest.service;

import com.github.seif.apirest.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    UserDto createUser(UserDto dto);
    UserDto getUser(Long id);
    Page<UserDto> listUsers(Pageable pageable);
}
