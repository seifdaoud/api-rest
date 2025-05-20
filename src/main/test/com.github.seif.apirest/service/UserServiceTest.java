package com.github.seif.apirest.service;

import com.github.seif.apirest.dto.UserDto;
import com.github.seif.apirest.entity.User;
import com.github.seif.apirest.mapper.UserMapper;
import com.github.seif.apirest.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock    UserRepository repo;
    @InjectMocks UserServiceImpl service;

    UserServiceTest() { MockitoAnnotations.openMocks(this); }

    @Test
    void createUser() {
        UserDto dto = new UserDto(null, "John", "john@ex.com");
        User saved = UserMapper.toEntity(dto);
        saved.setId(1L);

        when(repo.save(any())).thenReturn(saved);

        UserDto out = service.createUser(dto);

        assertEquals("John", out.name());
        verify(repo).save(any());
    }

    @Test
    void getUser() {
        User u = new User(); u.setId(1L); u.setName("Jane"); u.setEmail("j@ex.com");
        when(repo.findById(1L)).thenReturn(Optional.of(u));

        UserDto out = service.getUser(1L);

        assertEquals("Jane", out.name());
    }
}
