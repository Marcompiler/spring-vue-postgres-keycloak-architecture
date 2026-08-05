package com.marcompiler.backend.helloworld;

import com.marcompiler.backend.config.security.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(HelloWorldController.class)
@ActiveProfiles("test")
@Import(SecurityConfig.class)
public class HelloWorldControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private HelloWorldService helloWorldService;

    @Test
    @WithMockUser(username = "demo-user")
    void testGetHelloWorldById() throws Exception {
        HelloWorld helloWorld = new HelloWorld("test");

        when(helloWorldService.getHelloWorldById(1L)).thenReturn(Optional.of(helloWorld));

        mockMvc.perform(get("/api/helloworld/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.helloMessage").value("test"));
    }

    @Test
    void testGetHelloWorldById_ShouldGetUnauthorized() throws Exception {
        HelloWorld helloWorld = new HelloWorld("test");

        when(helloWorldService.getHelloWorldById(1L)).thenReturn(Optional.of(helloWorld));

        mockMvc.perform(get("/api/helloworld/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void testHelloWorldUser() throws Exception {
        // JWT example for passing it by parameter to the method
        mockMvc.perform(get("/api/helloworld/user")
                        .with(jwt()
                                .jwt(jwt -> jwt
                                        .subject("123456")
                                        .claim("preferred_username", "demo-user"))
                                .authorities(
                                        new SimpleGrantedAuthority("ROLE_demo:read:users"), // Client scoped role from SSO
                                        new SimpleGrantedAuthority("ROLE_demo-role-users") // Realm scoped role from SSO
                                )
                        )
                )
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "demo-admin", roles = {"demo:write:users", "demo-role-admins"})
    void testHelloWorldAdmin() throws Exception {
        mockMvc.perform(get("/api/helloworld/admin")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testHelloWorldAdmin_ShouldGetUnauthorized() throws Exception {
        mockMvc.perform(get("/api/helloworld/admin")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(username = "demo-user", roles = {"demo:read:users", "demo-role-users"})
    void testHelloWorldAdmin_ShouldGetForbidden() throws Exception {
        mockMvc.perform(get("/api/helloworld/admin")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }
}
