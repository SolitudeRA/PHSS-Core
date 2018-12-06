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
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ExtendWith({SpringExtension.class, RestDocumentationExtension.class})
public class MusicApiTest {
    private static final String urlBase = "/music";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setUp(RestDocumentationContextProvider restDocumentationContextProvider) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                                      .apply(documentationConfiguration(restDocumentationContextProvider))
                                      .build();
    }

    @Test
    @WithMockUser(username = "alpha", password = "test")
    public void testCase_1_uploadTrack() throws Exception {
        this.mockMvc.perform(fileUpload(urlBase + "/upload")
                                     .file(new MockMultipartFile("track", "MEGALOBOX.aiff", "multipart/form-data", Files.readAllBytes(Paths.get("src/test/resources/files/MEGALOBOX.aiff").toAbsolutePath())))
                                     .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(document("upload-album", responseFields(
                            fieldWithPath("")
                    )));
    }

    @Test
    @WithMockUser(username = "alpha", password = "test")
    public void testCase_2_uploadTracks() throws Exception {
        this.mockMvc.perform(fileUpload(urlBase + "/multiupload")
                                     .file("MEGALOBOX.aiff", Files.readAllBytes(Paths.get("src/test/resources/files/MEGALOBOX.aiff").toAbsolutePath()))
                                     .file("ちいさな冒険者.aiff", Files.readAllBytes(Paths.get("src/test/resources/files/ちいさな冒険者.aiff").toAbsolutePath()))
                                     .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(document("upload-albums"));
    }


    @Test
    @WithMockUser(username = "alpha", password = "test")
    public void testCase_3_listUserAlbum() throws Exception {
        this.mockMvc.perform(get(urlBase + "/album").accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(document("list-user-album"));
    }

    @Test
    @WithMockUser(username = "alpha", password = "test")
    public void testCase_4_getAlbum() throws Exception {
        this.mockMvc.perform(get(urlBase + "/album/").accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(document("get-album"));
    }

    @Test
    @WithMockUser(username = "alpha", password = "test")
    public void testCase_5_updateAlbum() throws Exception {
        this.mockMvc.perform(patch(urlBase + "/album/{uuid}/update", "").accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(document("update-album"));
    }
}
