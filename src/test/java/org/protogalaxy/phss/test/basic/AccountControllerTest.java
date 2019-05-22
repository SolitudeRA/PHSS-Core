package org.protogalaxy.phss.test.basic;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
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
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void accountTest_1_registerAccount() throws Exception {
        this.mockMvc.perform(post("/account/register")
                .param("username", "test")
                .param("password", "123456"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("test"));
    }

    @Test
    public void accountTest_2_login() throws Exception {
        RequestBuilder requestBuilder = formLogin()
                .loginProcessingUrl("/account/login")
                .user("test").password("123456");
        this.mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());
    }

    @Test
    @WithUserDetails(value = "test", userDetailsServiceBeanName = "userDetailsService")
    public void accountTest_3_retrieveAccount() throws Exception {
        this.mockMvc.perform(get("/account/test"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("test"));
    }

    @Test
    @WithUserDetails(value = "test", userDetailsServiceBeanName = "userDetailsService")
    public void accountTest_4_disableAccount() throws Exception {
        this.mockMvc.perform(patch("/account/test/enable"))
                .andExpect(status().isOk());
    }

    @Test
    @WithUserDetails(value = "test", userDetailsServiceBeanName = "userDetailsService")
    public void accountTest_5_enableAccount() throws Exception {
        this.mockMvc.perform(patch("/account/test/disable"))
                .andExpect(status().isOk());
    }

    @Test
    @WithUserDetails(value = "test", userDetailsServiceBeanName = "userDetailsService")
    public void accountTest_6_unlockAccount() throws Exception {
        this.mockMvc.perform(patch("/account/test/unlock"))
                .andExpect(status().isOk());
    }

    @Test
    @WithUserDetails(value = "test", userDetailsServiceBeanName = "userDetailsService")
    public void accountTest_7_lockAccount() throws Exception {
        this.mockMvc.perform(patch("/account/test/lock"))
                .andExpect(status().isOk());
    }

    @Test
    @WithUserDetails(value = "test", userDetailsServiceBeanName = "userDetailsService")
    public void accountTest_8_expireAccount() throws Exception {
        this.mockMvc.perform(patch("/account/test/expire"))
                .andExpect(status().isOk());
    }
}
