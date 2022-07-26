package com.timal1.spring.web.cart;

import com.timal1.spring.web.api.carts.CartDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CartTest {
    @Mock
    private RedisTemplate<String, Object> redisTemplate;

    @Mock
    private ValueOperations<String, Object> valueOperations;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void cartCreationTest() throws Exception {
        CartDto cartDto = new CartDto();
        Mockito.doReturn(true)
                .when(redisTemplate)
                .hasKey("0");
        Mockito.doReturn(valueOperations)
                .when(redisTemplate)
                .opsForValue();
        Mockito.doReturn(cartDto)
                .when(valueOperations)
                .get("0");
        mockMvc.perform(get("/api/v1/cart/0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());
    }
}