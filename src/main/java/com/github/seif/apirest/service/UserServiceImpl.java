package com.github.seif.apirest.service;

import com.github.seif.apirest.dto.UserDto;
import com.github.seif.apirest.entity.User;
import com.github.seif.apirest.mapper.UserMapper;
import com.github.seif.apirest.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDto createUser(UserDto dto) {
        User saved = repo.save(UserMapper.toEntity(dto));
        return UserMapper.toDto(saved);
    }

    @Override
    public UserDto getUser(Long id) {
        User u = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User " + id + " not found"));
        return UserMapper.toDto(u);
    }

    @Override
    public Page<UserDto> listUsers(Pageable p) {
        return repo.findAll(p).map(UserMapper::toDto);
    }
}
