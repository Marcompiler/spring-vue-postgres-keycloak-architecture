package com.marcompiler.backend.users;

import com.marcompiler.backend.config.security.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MyUserController.class)
@ActiveProfiles("test")
@Import(SecurityConfig.class)
class MyUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private MyUserService myUserService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser(username = "demo-user")
    void testGetAllUsers() throws Exception {
        MyUser user1 = new MyUser("sub-1", "User1");
        MyUser user2 = new MyUser("sub-2", "User2");

        when(myUserService.getUsers()).thenReturn(List.of(user1, user2));

        mockMvc.perform(get("/api/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].surname").value("User1"))
                .andExpect(jsonPath("$[1].surname").value("User2"));
    }

    @Test
    @WithMockUser(username = "demo-user")
    void testGetUserById() throws Exception {
        MyUser user = new MyUser("sub-123", "TestUser");

        when(myUserService.getUserById(1L)).thenReturn(Optional.of(user));

        mockMvc.perform(get("/api/users/id/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.surname").value("TestUser"));
    }

    @Test
    @WithMockUser(username = "demo-user")
    void testGetUserByIdNotFound() throws Exception {
        when(myUserService.getUserById(999L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/users/id/999")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser(username = "demo-user")
    void testGetUserBySub() throws Exception {
        MyUser user = new MyUser("sub-123", "TestUser");

        when(myUserService.getUserBySub("sub-123")).thenReturn(Optional.of(user));

        mockMvc.perform(get("/api/users/sub/sub-123")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sub").value("sub-123"));
    }

    @Test
    @WithMockUser(username = "demo-user", roles = {"demo:write:users"})
    void testDeleteUser() throws Exception {
        when(myUserService.userExistsById(1L)).thenReturn(true);

        mockMvc.perform(delete("/api/users/delete/1")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "demo-user", roles = {"demo:write:users"})
    void testDeleteUserNotFound() throws Exception {
        when(myUserService.userExistsById(999L)).thenReturn(false);

        mockMvc.perform(delete("/api/users/delete/999")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void testRegisterUserUnauthorized() throws Exception {
        mockMvc.perform(post("/api/users/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(Map.of("surname", "NewUser"))))
                .andExpect(status().isUnauthorized());
    }
}