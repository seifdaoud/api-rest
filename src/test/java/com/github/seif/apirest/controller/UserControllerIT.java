package com.github.seif.apirest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.seif.apirest.config.TestcontainersConfig;
import com.github.seif.apirest.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)   //  désactive Spring Security
class UserControllerIT extends TestcontainersConfig {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @Test
    void createUser() throws Exception {
        UserDto dto = new UserDto(null, "John Doe", "john@ex.com");

        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"));
    }
}
