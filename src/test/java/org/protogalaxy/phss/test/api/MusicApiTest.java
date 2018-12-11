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
import org.springframework.restdocs.payload.JsonFieldType;
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
                    .andDo(document("upload-track", responseFields(
                            fieldWithPath("title")
                                    .type(JsonFieldType.STRING)
                                    .description("Title of the track"),
                            fieldWithPath("album")
                                    .type(JsonFieldType.STRING)
                                    .description("Album of the track"),
                            fieldWithPath("artist")
                                    .type(JsonFieldType.STRING)
                                    .description("Artist of the track"),
                            fieldWithPath("location")
                                    .type(JsonFieldType.STRING)
                                    .description("Address of the track"),
                            fieldWithPath("albumArtist")
                                    .type(JsonFieldType.STRING)
                                    .description("Album artist of the track"),
                            fieldWithPath("composer")
                                    .type(JsonFieldType.STRING)
                                    .description("Composer of the track"),
                            fieldWithPath("releaseYear")
                                    .type(JsonFieldType.STRING)
                                    .description("Release year of the track"),
                            fieldWithPath("trackNumber")
                                    .type(JsonFieldType.NUMBER)
                                    .description("Track number of the disc"),
                            fieldWithPath("trackTotal")
                                    .type(JsonFieldType.NUMBER)
                                    .description("Total tracks of the disc"),
                            fieldWithPath("discNumber")
                                    .type(JsonFieldType.NUMBER)
                                    .description("Disc number of discs"),
                            fieldWithPath("discTotal")
                                    .type(JsonFieldType.NUMBER)
                                    .description("Total discs"),
                            fieldWithPath("score")
                                    .type(JsonFieldType.NUMBER)
                                    .description("Score of the track"),
                            fieldWithPath("genre")
                                    .type(JsonFieldType.ARRAY)
                                    .description("Genre list of the track"),
                            fieldWithPath("artwork")
                                    .type(JsonFieldType.STRING)
                                    .description("Artwork address of the track"),
                            fieldWithPath("love")
                                    .type(JsonFieldType.BOOLEAN)
                                    .description("Whether you love the track"),
                            fieldWithPath("dislike")
                                    .type(JsonFieldType.BOOLEAN)
                                    .description("Whether you don't like the track"),
                            fieldWithPath("comment")
                                    .type(JsonFieldType.STRING)
                                    .description("Comment of the track"),
                            fieldWithPath("kind")
                                    .type(JsonFieldType.STRING)
                                    .description("Kind of the track"),
                            fieldWithPath("duration")
                                    .type(JsonFieldType.STRING)
                                    .description("Duration of the track"),
                            fieldWithPath("size")
                                    .type(JsonFieldType.NUMBER)
                                    .description("Size of the track"),
                            fieldWithPath("bitRate")
                                    .type(JsonFieldType.STRING)
                                    .description("Bitrate of the track"),
                            fieldWithPath("bitDepth")
                                    .type(JsonFieldType.STRING)
                                    .description("Bitdepth of the track"),
                            fieldWithPath("sampleRate")
                                    .type(JsonFieldType.STRING)
                                    .description("Sample rate of the track"),
                            fieldWithPath("playbackCount")
                                    .type(JsonFieldType.NUMBER)
                                    .description("Playback count of the track"),
                            fieldWithPath("skipCount")
                                    .type(JsonFieldType.NUMBER)
                                    .description("Skip count of the track"),
                            fieldWithPath("lastPlayed")
                                    .type(JsonFieldType.STRING)
                                    .description("Last played time of the track"),
                            fieldWithPath("dateAdded")
                                    .type(JsonFieldType.STRING)
                                    .description("Added date of the track"),
                            fieldWithPath("dateModified")
                                    .type(JsonFieldType.STRING)
                                    .description("Modified date of the track")
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
                    .andDo(document("upload-tracks", responseFields(
                            fieldWithPath("[].title")
                                    .type(JsonFieldType.STRING)
                                    .description("Title of the track"),
                            fieldWithPath("[].album")
                                    .type(JsonFieldType.STRING)
                                    .description("Album of the track"),
                            fieldWithPath("[].artist")
                                    .type(JsonFieldType.STRING)
                                    .description("Artist of the track"),
                            fieldWithPath("[].location")
                                    .type(JsonFieldType.STRING)
                                    .description("Address of the track"),
                            fieldWithPath("[].albumArtist")
                                    .type(JsonFieldType.STRING)
                                    .description("Album artist of the track"),
                            fieldWithPath("[].composer")
                                    .type(JsonFieldType.STRING)
                                    .description("Composer of the track"),
                            fieldWithPath("[].releaseYear")
                                    .type(JsonFieldType.STRING)
                                    .description("Release year of the track"),
                            fieldWithPath("[].trackNumber")
                                    .type(JsonFieldType.NUMBER)
                                    .description("Track number of the disc"),
                            fieldWithPath("[].trackTotal")
                                    .type(JsonFieldType.NUMBER)
                                    .description("Total tracks of the disc"),
                            fieldWithPath("[].discNumber")
                                    .type(JsonFieldType.NUMBER)
                                    .description("Disc number of discs"),
                            fieldWithPath("[].discTotal")
                                    .type(JsonFieldType.NUMBER)
                                    .description("Total discs"),
                            fieldWithPath("[].score")
                                    .type(JsonFieldType.NUMBER)
                                    .description("Score of the track"),
                            fieldWithPath("[].genre")
                                    .type(JsonFieldType.ARRAY)
                                    .description("Genre list of the track"),
                            fieldWithPath("[].artwork")
                                    .type(JsonFieldType.STRING)
                                    .description("Artwork address of the track"),
                            fieldWithPath("[].love")
                                    .type(JsonFieldType.BOOLEAN)
                                    .description("Whether you love the track"),
                            fieldWithPath("[].dislike")
                                    .type(JsonFieldType.BOOLEAN)
                                    .description("Whether you don't like the track"),
                            fieldWithPath("[].comment")
                                    .type(JsonFieldType.STRING)
                                    .description("Comment of the track"),
                            fieldWithPath("[].kind")
                                    .type(JsonFieldType.STRING)
                                    .description("Kind of the track"),
                            fieldWithPath("[].duration")
                                    .type(JsonFieldType.STRING)
                                    .description("Duration of the track"),
                            fieldWithPath("[].size")
                                    .type(JsonFieldType.NUMBER)
                                    .description("Size of the track"),
                            fieldWithPath("[].bitRate")
                                    .type(JsonFieldType.STRING)
                                    .description("Bitrate of the track"),
                            fieldWithPath("[].bitDepth")
                                    .type(JsonFieldType.STRING)
                                    .description("Bitdepth of the track"),
                            fieldWithPath("[].sampleRate")
                                    .type(JsonFieldType.STRING)
                                    .description("Sample rate of the track"),
                            fieldWithPath("[].playbackCount")
                                    .type(JsonFieldType.NUMBER)
                                    .description("Playback count of the track"),
                            fieldWithPath("[].skipCount")
                                    .type(JsonFieldType.NUMBER)
                                    .description("Skip count of the track"),
                            fieldWithPath("[].lastPlayed")
                                    .type(JsonFieldType.STRING)
                                    .description("Last played time of the track"),
                            fieldWithPath("[].dateAdded")
                                    .type(JsonFieldType.STRING)
                                    .description("Added date of the track"),
                            fieldWithPath("[].dateModified")
                                    .type(JsonFieldType.STRING)
                                    .description("Modified date of the track"),
                            fieldWithPath("[].links")
                                    .type(JsonFieldType.ARRAY)
                                    .description("Other links")
                    )));
    }


    @Test
    @WithMockUser(username = "alpha", password = "test")
    public void testCase_3_listUserAlbum() throws Exception {
        this.mockMvc.perform(get(urlBase + "/album").accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(document("list-user-album", responseFields(
                            fieldWithPath("[].title")
                                    .type(JsonFieldType.STRING)
                                    .description("Title of the track"),
                            fieldWithPath("[].album")
                                    .type(JsonFieldType.STRING)
                                    .description("Album of the track"),
                            fieldWithPath("[].artist")
                                    .type(JsonFieldType.STRING)
                                    .description("Artist of the track"),
                            fieldWithPath("[].location")
                                    .type(JsonFieldType.STRING)
                                    .description("Address of the track"),
                            fieldWithPath("[].albumArtist")
                                    .type(JsonFieldType.STRING)
                                    .description("Album artist of the track"),
                            fieldWithPath("[].composer")
                                    .type(JsonFieldType.STRING)
                                    .description("Composer of the track"),
                            fieldWithPath("[].releaseYear")
                                    .type(JsonFieldType.STRING)
                                    .description("Release year of the track"),
                            fieldWithPath("[].trackNumber")
                                    .type(JsonFieldType.NUMBER)
                                    .description("Track number of the disc"),
                            fieldWithPath("[].trackTotal")
                                    .type(JsonFieldType.NUMBER)
                                    .description("Total tracks of the disc"),
                            fieldWithPath("[].discNumber")
                                    .type(JsonFieldType.NUMBER)
                                    .description("Disc number of discs"),
                            fieldWithPath("[].discTotal")
                                    .type(JsonFieldType.NUMBER)
                                    .description("Total discs"),
                            fieldWithPath("[].score")
                                    .type(JsonFieldType.NUMBER)
                                    .description("Score of the track"),
                            fieldWithPath("[].genre")
                                    .type(JsonFieldType.ARRAY)
                                    .description("Genre list of the track"),
                            fieldWithPath("[].artwork")
                                    .type(JsonFieldType.STRING)
                                    .description("Artwork address of the track"),
                            fieldWithPath("[].love")
                                    .type(JsonFieldType.BOOLEAN)
                                    .description("Whether you love the track"),
                            fieldWithPath("[].dislike")
                                    .type(JsonFieldType.BOOLEAN)
                                    .description("Whether you don't like the track"),
                            fieldWithPath("[].comment")
                                    .type(JsonFieldType.STRING)
                                    .description("Comment of the track"),
                            fieldWithPath("[].kind")
                                    .type(JsonFieldType.STRING)
                                    .description("Kind of the track"),
                            fieldWithPath("[].duration")
                                    .type(JsonFieldType.STRING)
                                    .description("Duration of the track"),
                            fieldWithPath("[].size")
                                    .type(JsonFieldType.NUMBER)
                                    .description("Size of the track"),
                            fieldWithPath("[].bitRate")
                                    .type(JsonFieldType.STRING)
                                    .description("Bitrate of the track"),
                            fieldWithPath("[].bitDepth")
                                    .type(JsonFieldType.STRING)
                                    .description("Bitdepth of the track"),
                            fieldWithPath("[].sampleRate")
                                    .type(JsonFieldType.STRING)
                                    .description("Sample rate of the track"),
                            fieldWithPath("[].playbackCount")
                                    .type(JsonFieldType.NUMBER)
                                    .description("Playback count of the track"),
                            fieldWithPath("[].skipCount")
                                    .type(JsonFieldType.NUMBER)
                                    .description("Skip count of the track"),
                            fieldWithPath("[].lastPlayed")
                                    .type(JsonFieldType.STRING)
                                    .description("Last played time of the track"),
                            fieldWithPath("[].dateAdded")
                                    .type(JsonFieldType.STRING)
                                    .description("Added date of the track"),
                            fieldWithPath("[].dateModified")
                                    .type(JsonFieldType.STRING)
                                    .description("Modified date of the track"),
                            fieldWithPath("[].links")
                                    .type(JsonFieldType.ARRAY)
                                    .description("Other links")
                    )));
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
