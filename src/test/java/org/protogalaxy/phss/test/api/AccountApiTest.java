package org.protogalaxy.phss.test.api;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ExtendWith({SpringExtension.class, RestDocumentationExtension.class})
public class AccountApiTest {
    private static final String urlBase = "/account";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setUp(RestDocumentationContextProvider restDocumentationContextProvider) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                                      .apply(documentationConfiguration(restDocumentationContextProvider))
                                      .alwaysDo(document("{ClassName}/{step}"))
                                      .build();
    }

    @Test
    @Rollback(value = false)
    public void testCase_1_register() throws Exception {
        this.mockMvc.perform(post(urlBase + "/register")
                                     .param("username", "alpha")
                                     .param("password", "test")
                                     .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(document("register-account",
                                    requestParameters(
                                            parameterWithName("username").description("Name of the account"),
                                            parameterWithName("password").description("Password of the account")
                                    )));
    }

    @Test
    @WithMockUser(username = "alpha", password = "test")
    public void testCase_2_getAccount() throws Exception {
        this.mockMvc.perform(get(urlBase + "/{username}", "alpha"))
                    .andExpect(status().isOk())
                    .andDo(document("get-account-with-username", pathParameters(parameterWithName("username").description("Name of the account"))));
    }

    @Test
    @WithMockUser(username = "alpha", password = "test")
    public void testCase_3_disableAccount() throws Exception {
        this.mockMvc.perform(patch(urlBase + "/{username}/disable", "alpha"))
                    .andExpect(status().isOk())
                    .andDo(document("disable-account", pathParameters(parameterWithName("username").description("Name of the account"))));
    }

    @Test
    @WithMockUser(username = "alpha", password = "test")
    public void testCase_4_enableAccount() throws Exception {
        this.mockMvc.perform(patch(urlBase + "/{username}/enable", "alpha"))
                    .andExpect(status().isOk())
                    .andDo(document("enable-account", pathParameters(parameterWithName("username").description("Name of the account"))));
    }

    @Test
    @WithMockUser(username = "alpha", password = "test")
    public void testCase_5_lockAccount() throws Exception {
        this.mockMvc.perform(patch(urlBase + "/{username}/lock", "alpha"))
                    .andExpect(status().isOk())
                    .andDo(document("lock-account", pathParameters(parameterWithName("username").description("Name of the account"))));
    }

    @Test
    @WithMockUser(username = "alpha", password = "test")
    public void testCase_6_unlockAccount() throws Exception {
        this.mockMvc.perform(patch(urlBase + "/{username}/unlock", "alpha"))
                    .andExpect(status().isOk())
                    .andDo(document("unlock-account", pathParameters(parameterWithName("username").description("Name of the account"))));
    }

    @Test
    @WithMockUser(username = "alpha", password = "test")
    public void testCase_7_expireAccount() throws Exception {
        this.mockMvc.perform(patch(urlBase + "/{username}/expire", "alpha"))
                    .andExpect(status().isOk())
                    .andDo(document("expire-account", pathParameters(parameterWithName("username").description("Name of the account"))));
    }
}
