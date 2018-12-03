package org.protogalaxy.phss.test.api;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.protogalaxy.phss.controller.filesystem.MusicController;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureRestDocs
@RunWith(SpringRunner.class)
@WebMvcTest(MusicController.class)
@ExtendWith({SpringExtension.class, RestDocumentationExtension.class})
public class MusicApiTest {
    private static final String urlBase = "/album";

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentationContextProvider) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                                      .apply(documentationConfiguration(restDocumentationContextProvider))
                                      .build();
    }

    @Test
    public void index() throws Exception {
        this.mockMvc.perform(get(urlBase).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(document("music",
                                    links(halLinks(),
                                          linkWithRel("upload").description("Upload a track"),
                                          linkWithRel("multiupload").description("Upload tracks"),
                                          linkWithRel("album").description("List user album"),
                                          linkWithRel("album/{uuid}").description("Get an album with UUID"))
                    ));
    }

    @Test
    public void uploadTrack() throws Exception {
        this.mockMvc.perform(multipart(urlBase + "/upload")
                                     .file("track", "test".getBytes())
                                     .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(document("upload-album"));
    }

    @Test
    public void listUserAlbum() throws Exception {
        this.mockMvc.perform(get(urlBase + "/album").accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(document("list-user-album"));
    }

    @Test
    public void getAlbumByUUID(String uuid) throws Exception {
        this.mockMvc.perform(get(urlBase + "/album/" + uuid).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(document("get-album-by-uuid"));
    }
}
