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
                    .andExpect(status().isCreated())
                    .andDo(document("upload-album", responseFields(
                            fieldWithPath("title").description("Title of the track"),
                            fieldWithPath("album").description("Album of the track"),
                            fieldWithPath("artist").description("Artist of the track"),
                            fieldWithPath("location").description("Address of the track"),
                            fieldWithPath("albumArtist").description("Album artist of the track"),
                            fieldWithPath("composer").description("Composer of the track"),
                            fieldWithPath("releaseYear").description("Release year of the track"),
                            fieldWithPath("trackNumber").description("Track number of the disc"),
                            fieldWithPath("trackTotal").description("Total tracks of the disc"),
                            fieldWithPath("discNumber").description("Disc number of discs"),
                            fieldWithPath("discTotal").description("Total discs"),
                            fieldWithPath("score").description("Score of the track"),
                            fieldWithPath("genre").description("Genre list of the track"),
                            fieldWithPath("artwork").description("Artwork address of the track"),
                            fieldWithPath("love").description("Whether you love the track"),
                            fieldWithPath("dislike").description("Whether you don't like the track"),
                            fieldWithPath("comment").description("Comment of the track"),
                            fieldWithPath("kind").description("Kind of the track"),
                            fieldWithPath("duration").description("Duration of the track"),
                            fieldWithPath("size").description("Size of the track"),
                            fieldWithPath("bitRate").description("Bitrate of the track"),
                            fieldWithPath("bitDepth").description("Bitdepth of the track"),
                            fieldWithPath("sampleRate").description("Sample rate of the track"),
                            fieldWithPath("playbackCount").description("Playback count of the track"),
                            fieldWithPath("skipCount").description("Skip count of the track"),
                            fieldWithPath("lastPlayed").description("Last played time of the track"),
                            fieldWithPath("dateAdded").description("Added date of the track"),
                            fieldWithPath("dateModified").description("Modified date of the track")
                    )));
    }

    @Test
    @WithMockUser(username = "alpha", password = "test")
    public void testCase_2_uploadTracks() throws Exception {
        this.mockMvc.perform(fileUpload(urlBase + "/multiupload")
                                     .file(new MockMultipartFile("tracks", "淘汰.aiff", "multipart/form-data", Files.readAllBytes(Paths.get("src/test/resources/files/淘汰.aiff").toAbsolutePath())))
                                     .file(new MockMultipartFile("tracks", "ちいさな冒険者.aiff", "multipart/form-data", Files.readAllBytes(Paths.get("src/test/resources/files/ちいさな冒険者.aiff").toAbsolutePath())))
                                     .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated())
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
