package com.timal1.spring.web.auth;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SecurityTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void securityTokenTest() throws Exception {
        String jsonRequest = "{\n" +
                "\t\"username\": \"Egor\",\n" +
                "\t\"password\": \"400\"\n" +
                "}";
        MvcResult result = mockMvc.perform(
                post("/auth")
                        .content(jsonRequest)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn();
    }
}
