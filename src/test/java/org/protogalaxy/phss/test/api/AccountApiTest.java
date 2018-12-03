package org.protogalaxy.phss.test.api;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.protogalaxy.phss.controller.AccountController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureRestDocs
@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
@ExtendWith({SpringExtension.class, RestDocumentationExtension.class})
public class AccountApiTest {
    private static final String urlBase = "/account";

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentationContextProvider) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                                      .apply(documentationConfiguration(restDocumentationContextProvider))
                                      .build();
    }

    @Test
    public void register() throws Exception {
        this.mockMvc.perform(post(urlBase + "/register")
                                     .param("username", "alpha")
                                     .param("password", "test")
                                     .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(document("Register account",
                                    requestParameters(
                                            parameterWithName("username").description("Name of the account"),
                                            parameterWithName("password").description("Password of the account")
                                    )));
    }

    @Test
    public void getAccount() throws Exception {
        this.mockMvc.perform(get(urlBase + "{username}", "alpha"))
                    .andExpect(status().isOk())
                    .andDo(document("Get account with username", pathParameters(parameterWithName("username").description("Name of the account"))));
    }
}
