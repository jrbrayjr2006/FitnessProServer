package com.jaydot2.fitnesspro.server.controller;

import com.jaydot2.fitnesspro.server.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

class CoreControllerTest {

    CoreController controller;
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        controller = new CoreController();
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    @DisplayName("Given a new user is created, when a request is sent, then return a status of accepted")
    void whenCreateUserThenShouldReturnStatusOfAccepted() throws Exception {
        // Given
        User user = new User();
        user.setFirstname("AnyFirst");
        user.setLastname("AnyLast");
        user.setUsername("anyuser");
        // When
        mockMvc.perform(post("/fitnesspro/user").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isAccepted());

        // Then
    }
}