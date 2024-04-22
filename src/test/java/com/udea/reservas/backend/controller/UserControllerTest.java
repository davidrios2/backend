package com.udea.reservas.backend.controller;

import com.udea.reservas.backend.model.User;
import com.udea.reservas.backend.service.UserService;
import com.udea.reservas.backend.respository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    private User user;

    @BeforeEach
    public void setup() {
        user = new User();
        user.setId(1L);
        user.setName("Juanito");
        user.setLastName("Perez");
        user.setEmail("test@email.com");
        user.setPhoneNumber("1234567890");
        user.setCedula("123456789");
    }

    @Test
    void getUserByCedulaTest() throws Exception {
        when(userService.getUserByCedula("123456789")).thenReturn(user);

        mockMvc.perform(get("/user/cedula/123456789")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Juanito\",\"lastName\":\"Perez\",\"email\":\"test@email.com\",\"phoneNumber\":\"1234567890\",\"cedula\":\"123456789\"}"));
    }
}