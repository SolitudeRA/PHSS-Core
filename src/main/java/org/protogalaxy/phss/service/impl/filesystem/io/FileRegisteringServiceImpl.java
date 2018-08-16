package org.protogalaxy.phss.service.impl.filesystem.io;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.protogalaxy.phss.component.file.FileConsts;
import org.protogalaxy.phss.datasource.entity.filesystem.album.music.MusicTrackEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.album.music.MusicTrackInfEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.album.music.MusicTrackInfStaticEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.album.photo.PhotoEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.document.*;
import org.protogalaxy.phss.datasource.entity.filesystem.illustration.IllustrationEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.movie.AnimeEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.movie.MovieEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.movie.VideoEntity;
import org.protogalaxy.phss.datasource.repository.jpa.filesystem.album.music.MusicTrackRepository;
import org.protogalaxy.phss.datasource.repository.jpa.filesystem.main.FilesystemMainRepository;
import org.protogalaxy.phss.datasource.repository.mongodb.document.*;
import org.protogalaxy.phss.service.main.filesystem.io.FileRegisteringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.Date;
import java.util.Map;

@Service
public class FileRegisteringServiceImpl implements FileRegisteringService {
    private final FilesystemMainRepository filesystemMainRepository;
    private final MusicTrackRepository musicTrackRepository;
    private final DocumentAdobePdfRepository documentAdobePdfRepository;
    private final DocumentAdobePhotoshopRepository documentAdobePhotoshopRepository;
    private final DocumentMicrosoftWordOldRepository documentMicrosoftWordOldRepository;
    private final DocumentMicrosoftExcelOldRepository documentMicrosoftExcelOldRepository;
    private final DocumentMicrosoftPowerpointOldRepository documentMicrosoftPowerpointOldRepository;
    private final DocumentMicrosoftWordRepository documentMicrosoftWordRepository;
    private final DocumentMicrosoftExcelRepository documentMicrosoftExcelRepository;
    private final DocumentMicrosoftPowerpointRepository documentMicrosoftPowerpointRepository;
    private final DocumentOpenTextRepository documentOpenTextRepository;
    private final DocumentOpenSpreadsheetRepository documentOpenSpreadsheetRepository;
    private final DocumentOpenPresentationRepository documentOpenPresentationRepository;

    @Autowired
    public FileRegisteringServiceImpl(FilesystemMainRepository filesystemMainRepository,
                                      MusicTrackRepository musicTrackRepository,
                                      DocumentAdobePdfRepository documentAdobePdfRepository,
                                      DocumentAdobePhotoshopRepository documentAdobePhotoshopRepository,
                                      DocumentMicrosoftWordOldRepository documentMicrosoftWordOldRepository,
                                      DocumentMicrosoftExcelOldRepository documentMicrosoftExcelOldRepository,
                                      DocumentMicrosoftPowerpointOldRepository documentMicrosoftPowerpointOldRepository,
                                      DocumentMicrosoftWordRepository documentMicrosoftWordRepository,
                                      DocumentMicrosoftExcelRepository documentMicrosoftExcelRepository,
                                      DocumentMicrosoftPowerpointRepository documentMicrosoftPowerpointRepository,
                                      DocumentOpenTextRepository documentOpenTextRepository,
                                      DocumentOpenSpreadsheetRepository documentOpenSpreadsheetRepository,
                                      DocumentOpenPresentationRepository documentOpenPresentationRepository) {
        this.filesystemMainRepository = filesystemMainRepository;
        this.musicTrackRepository = musicTrackRepository;
        this.documentAdobePdfRepository = documentAdobePdfRepository;
        this.documentAdobePhotoshopRepository = documentAdobePhotoshopRepository;
        this.documentMicrosoftWordOldRepository = documentMicrosoftWordOldRepository;
        this.documentMicrosoftExcelOldRepository = documentMicrosoftExcelOldRepository;
        this.documentMicrosoftPowerpointOldRepository = documentMicrosoftPowerpointOldRepository;
        this.documentMicrosoftWordRepository = documentMicrosoftWordRepository;
        this.documentMicrosoftExcelRepository = documentMicrosoftExcelRepository;
        this.documentMicrosoftPowerpointRepository = documentMicrosoftPowerpointRepository;
        this.documentOpenTextRepository = documentOpenTextRepository;
        this.documentOpenSpreadsheetRepository = documentOpenSpreadsheetRepository;
        this.documentOpenPresentationRepository = documentOpenPresentationRepository;
    }

    @Override
    public MusicTrackEntity registerTrack(String username, Map<String, Object> metadata, byte[] artwork, Path path) throws Exception {
        MusicTrackEntity trackEntity = new MusicTrackEntity(
                filesystemMainRepository.findByUserEntity_Username(username),
                metadata.get("title").toString(),
                metadata.get("album").toString(),
                metadata.get("artist").toString(),
                metadata.get("album_artist").toString(),
                path.toString());
        trackEntity.setTrackInformation(new MusicTrackInfEntity(trackEntity));
        trackEntity.setTrackInformationStatic(new MusicTrackInfStaticEntity(
                metadata.get("size").toString(),
                metadata.get("duration").toString(),
                metadata.get("track").toString(),
                metadata.get("disc").toString(),
                metadata.get("date").toString(),
                artwork,
                metadata.get("genre").toString(),
                metadata.get("bitrate").toString(),
                metadata.get("sample_rate").toString(),
                metadata.get("bit_depth").toString(),
                trackEntity));
        musicTrackRepository.save(trackEntity);
        return trackEntity;
    }

    @Override
    public AnimeEntity registerAnime(String username, Map<String, String> metadata, Path path) throws Exception {
        return null;
    }

    @Override
    public MovieEntity registerMovie(String username, Map<String, String> metadata, Path path) throws Exception {
        return null;
    }

    @Override
    public VideoEntity registerVideo(String username, Map<String, String> metadata, Path path) throws Exception {
        return null;
    }

    @Override
    public PhotoEntity registerPhoto(String username, Map<String, String> metadata, Path path) throws Exception {
        return null;
    }

    @Override
    public String registerDocument(String username, Map<String, Object> metadata, Path path, String mimeType) throws Exception {
        switch (mimeType) {
            case FileConsts.MIME_ADOBE_PDF:
                return registerAdobePdf(username, metadata, path);
            case FileConsts.MIME_ADOBE_PHOTOSHOP:
                return registerAdobePhotoshop(username, metadata, path);
            case FileConsts.MIME_MICROSOFT_WORD_OLD:
                return registerMicrosoftWordOld(username, metadata, path);
            case FileConsts.MIME_MICROSOFT_EXCEL_OLD:
                return registerMicrosoftExcelOld(username, metadata, path);
            case FileConsts.MIME_MICROSOFT_POWERPOINT_OLD:
                return registerMicrosoftPowerpointOld(username, metadata, path);
            case FileConsts.MIME_MICROSOFT_WORD:
                return registerMicrosoftWord(username, metadata, path);
            case FileConsts.MIME_MICROSOFT_EXCEL:
                return registerMicrosoftExcel(username, metadata, path);
            case FileConsts.MIME_MICROSOFT_POWERPOINT:
                return registerMicrosoftPowerpoint(username, metadata, path);
            case FileConsts.MIME_OPENDOCUMENT_TEXT:
                return registerOpendocumentText(username, metadata, path);
            case FileConsts.MIME_OPENDOCUMENT_SPREADSHEET:
                return registerOpendocumentSpreadsheet(username, metadata, path);
            case FileConsts.MIME_OPENDOCUMENT_PRESENTATION:
                return registerOpendocumentPresentation(username, metadata, path);
        }
        return null;
    }

    @Override
    public IllustrationEntity registerIllustration(String username, Map<String, String> metadata, Path path) throws Exception {
        return null;
    }

    private String registerAdobePdf(String username, Map<String, Object> metadata, Path path) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        DocumentAdobePdfEntity documentAdobePdfEntity = new DocumentAdobePdfEntity((String) metadata.get(FileConsts.METADATA_ADOBE_PDF_TITLE),
                                                                                   (Date) metadata.get(FileConsts.METADATA_ADOBE_PDF_CREATED),
                                                                                   (Date) metadata.get(FileConsts.METADATA_ADOBE_PDF_MODIFIED),
                                                                                   null,
                                                                                   (String) metadata.get(FileConsts.METADATA_ADOBE_PDF_AUTHOR),
                                                                                   (String) metadata.get(FileConsts.METADATA_ADOBE_PDF_VERSION),
                                                                                   (String) metadata.get(FileConsts.METADATA_ADOBE_PDF_PRODUCER),
                                                                                   path.toString());
        documentAdobePdfRepository.save(documentAdobePdfEntity);
        return mapper.writeValueAsString(documentAdobePdfEntity);
    }

    private String registerAdobePhotoshop(String username, Map<String, Object> metadata, Path path) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        DocumentAdobePhotoshopEntity documentAdobePhotoshopEntity = new DocumentAdobePhotoshopEntity(null,null,null,null,null,null,0,0,null,0);
        documentAdobePhotoshopRepository.save(documentAdobePhotoshopEntity);
        return mapper.writeValueAsString(documentAdobePhotoshopEntity);
    }

    private String registerMicrosoftWordOld(String username, Map<String, Object> metadata, Path path) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        DocumentMicrosoftWordOldEntity documentMicrosoftWordOldEntity = new DocumentMicrosoftWordOldEntity(null,null,null,null,null,null,null,null,null,0,0,0,0,0,0);
        documentMicrosoftWordOldRepository.save(documentMicrosoftWordOldEntity);
        return mapper.writeValueAsString(documentMicrosoftWordOldEntity);
    }

    private String registerMicrosoftExcelOld(String username, Map<String, Object> metadata, Path path) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        DocumentMicrosoftExcelOldEntity documentMicrosoftExcelOldEntity = new DocumentMicrosoftExcelOldEntity(null,null,null,null,null,null,null,0);
        documentMicrosoftExcelOldRepository.save(documentMicrosoftExcelOldEntity);
        return mapper.writeValueAsString(documentMicrosoftExcelOldEntity);
    }

    private String registerMicrosoftPowerpointOld(String username, Map<String, Object> metadata, Path path) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();//
        DocumentMicrosoftPowerpointOldEntity documentMicrosoftPowerpointOldEntity = new DocumentMicrosoftPowerpointOldEntity(null,null,null,null,null,null,null,0,0,0,0,0,0,0,0,null);
        documentMicrosoftPowerpointOldRepository.save(documentMicrosoftPowerpointOldEntity);
        return mapper.writeValueAsString(documentMicrosoftPowerpointOldEntity);
    }

    private String registerMicrosoftWord(String username, Map<String, Object> metadata, Path path) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        DocumentMicrosoftWordEntity documentMicrosoftWordEntity = new DocumentMicrosoftWordEntity(null,null,null,null,null,null,null,null,0,0,0,0,0);
        documentMicrosoftWordRepository.save(documentMicrosoftWordEntity);
        return mapper.writeValueAsString(documentMicrosoftWordEntity);
    }

    private String registerMicrosoftExcel(String username, Map<String, Object> metadata, Path path) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        DocumentMicrosoftExcelEntity documentMicrosoftExcelEntity = new DocumentMicrosoftExcelEntity(null,null,null,null,null,null,null,null,0,0,0,0,0);
        documentMicrosoftExcelRepository.save(documentMicrosoftExcelEntity);
        return mapper.writeValueAsString(documentMicrosoftExcelEntity);
    }

    private String registerMicrosoftPowerpoint(String username, Map<String, Object> metadata, Path path) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        DocumentMicrosoftPowerpointEntity documentMicrosoftPowerpointEntity = new DocumentMicrosoftPowerpointEntity(null,null,null,null,null,null,null,null,0,0,0,0,0,null);
        documentMicrosoftPowerpointRepository.save(documentMicrosoftPowerpointEntity);
        return mapper.writeValueAsString(documentMicrosoftPowerpointEntity);
    }

    private String registerOpendocumentText(String username, Map<String, Object> metadata, Path path) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        DocumentOpenTextEntity documentOpenTextEntity = new DocumentOpenTextEntity(null,null,null,null,null,null,0,0,0,0,0,0);
        documentOpenTextRepository.save(documentOpenTextEntity);
        return mapper.writeValueAsString(documentOpenTextEntity);
    }

    private String registerOpendocumentSpreadsheet(String username, Map<String, Object> metadata, Path path) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        DocumentOpenSpreadsheetEntity documentOpenSpreadsheetEntity = new DocumentOpenSpreadsheetEntity(null,null,null,null,null,null);
        documentOpenSpreadsheetRepository.save(documentOpenSpreadsheetEntity);
        return mapper.writeValueAsString(documentOpenSpreadsheetEntity);
    }

    private String registerOpendocumentPresentation(String username, Map<String, Object> metadata, Path path) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        DocumentOpenPresentationEntity documentOpenPresentationEntity = new DocumentOpenPresentationEntity(null,null,null,null,null,null);
        documentOpenPresentationRepository.save(documentOpenPresentationEntity);
        return mapper.writeValueAsString(documentOpenPresentationEntity);
    }
}
