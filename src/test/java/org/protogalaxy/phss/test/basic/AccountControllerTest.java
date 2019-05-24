package org.protogalaxy.phss.test.basic;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.*;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.*;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    @DisplayName("register")
    public void accountTest_registerAccount() throws Exception {
        this.mockMvc.perform(post("/account/register")
                .param("username", "test")
                .param("password", "123456"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("test"));
    }

    @Test
    @Order(2)
    @DisplayName("login")
    public void accountTest_login() throws Exception {
        RequestBuilder requestBuilder = formLogin()
                .loginProcessingUrl("/account/login")
                .user("test").password("123456");
        this.mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());
    }

    @Test
    @Order(3)
    @DisplayName("retrieve_account")
    @WithUserDetails(value = "test", userDetailsServiceBeanName = "userDetailsService")
    public void accountTest_retrieveAccount() throws Exception {
        this.mockMvc.perform(get("/account/test"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("test"));
    }

    @Test
    @Order(4)
    @DisplayName("disable_account")
    @WithUserDetails(value = "test", userDetailsServiceBeanName = "userDetailsService")
    public void accountTest_disableAccount() throws Exception {
        this.mockMvc.perform(patch("/account/test/enable"))
                .andExpect(status().isOk());
    }

    @Test
    @Order(5)
    @DisplayName("enable_account")
    @WithUserDetails(value = "test", userDetailsServiceBeanName = "userDetailsService")
    public void accountTest_enableAccount() throws Exception {
        this.mockMvc.perform(patch("/account/test/disable"))
                .andExpect(status().isOk());
    }

    @Test
    @Order(6)
    @DisplayName("lock_account")
    @WithUserDetails(value = "test", userDetailsServiceBeanName = "userDetailsService")
    public void accountTest_lockAccount() throws Exception {
        this.mockMvc.perform(patch("/account/test/lock"))
                .andExpect(status().isOk());
    }

    @Test
    @Order(7)
    @DisplayName("unlock_account")
    @WithUserDetails(value = "test", userDetailsServiceBeanName = "userDetailsService")
    public void accountTest_unlockAccount() throws Exception {
        this.mockMvc.perform(patch("/account/test/unlock"))
                .andExpect(status().isOk());
    }

    @Test
    @Order(8)
    @DisplayName("expire_account")
    @WithUserDetails(value = "test", userDetailsServiceBeanName = "userDetailsService")
    public void accountTest_expireAccount() throws Exception {
        this.mockMvc.perform(patch("/account/test/expire"))
                .andExpect(status().isOk());
    }
}
