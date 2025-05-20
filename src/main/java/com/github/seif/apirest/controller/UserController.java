package com.github.seif.apirest.controller;

import com.github.seif.apirest.dto.UserDto;
import com.github.seif.apirest.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public UserDto create(@Valid @RequestBody UserDto dto) {
        return service.createUser(dto);
    }

    @GetMapping("/{id}")
    public UserDto read(@PathVariable Long id) {
        return service.getUser(id);
    }

    @GetMapping
    public Page<UserDto> list(Pageable pageable) {
        return service.listUsers(pageable);
    }
}
