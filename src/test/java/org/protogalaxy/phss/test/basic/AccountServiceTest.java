package org.protogalaxy.phss.test.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.protogalaxy.phss.controller.account.AccountController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WebMvcTest(AccountController.class)
public class AccountServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void registerAccount() throws Exception {
        this.mockMvc.perform(post("/account/register")).andExpect(status().isOk());
    }

    @Test
    public void retrieveAccount() throws Exception {

    }

    @Test
    public void enableAccount() throws Exception {

    }

    @Test
    public void disableAccount() throws Exception {

    }

    @Test
    public void lockAccount() throws Exception {

    }

    @Test
    public void unlockAccount() throws Exception {

    }

    @Test
    public void expireAccount() throws Exception {

    }
}
