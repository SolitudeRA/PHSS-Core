package org.protogalaxy.phss.service.main.filesystem.logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.time.LocalDateTime;
import org.protogalaxy.phss.component.consts.AudioConst;
import org.protogalaxy.phss.component.consts.FileConst;
import org.protogalaxy.phss.datasource.entity.filesystem.main.FileSystemMainEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicTrackEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicTrackInfoEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicTrackInfoStaticEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.photo.PhotoEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.book.BookEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.book.BookInfEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.document.*;
import org.protogalaxy.phss.datasource.entity.filesystem.illustration.IllustrationEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.anime.AnimeEpisodeEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.movie.MovieEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.video.VideoEntity;
import org.protogalaxy.phss.datasource.repository.jpa.filesystem.music.MusicTrackRepository;
import org.protogalaxy.phss.datasource.repository.jpa.filesystem.book.BookRepository;
import org.protogalaxy.phss.datasource.repository.jpa.filesystem.main.FilesystemMainRepository;
import org.protogalaxy.phss.datasource.repository.mongodb.document.*;
import org.protogalaxy.phss.service.interfaces.filesystem.io.CacheService;
import org.protogalaxy.phss.service.interfaces.filesystem.logic.FileRegisteringService;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.imageio.ImageIO;
import java.io.InputStream;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Date;
import java.util.Map;

public class FileRegisteringServiceImpl implements FileRegisteringService {
    //Services
    private final CacheService cacheService;

    //Database core repositories
    private final FilesystemMainRepository filesystemMainRepository;

    //Database database repositories
    private final MusicTrackRepository musicTrackRepository;
    private final BookRepository bookRepository;
    private final DocumentAdobePdfRepository documentAdobePdfRepository;
    private final DocumentAdobePhotoshopRepository documentAdobePhotoshopRepository;
    private final DocumentMicrosoftWordRepository documentMicrosoftWordRepository;
    private final DocumentMicrosoftWordOldRepository documentMicrosoftWordOldRepository;
    private final DocumentMicrosoftExcelRepository documentMicrosoftExcelRepository;
    private final DocumentMicrosoftExcelOldRepository documentMicrosoftExcelOldRepository;
    private final DocumentMicrosoftPowerpointRepository documentMicrosoftPowerpointRepository;
    private final DocumentMicrosoftPowerpointOldRepository documentMicrosoftPowerpointOldRepository;
    private final DocumentOpenTextRepository documentOpenTextRepository;
    private final DocumentOpenSpreadsheetRepository documentOpenSpreadsheetRepository;
    private final DocumentOpenPresentationRepository documentOpenPresentationRepository;

    public FileRegisteringServiceImpl(CacheService cacheService,
                                      FilesystemMainRepository filesystemMainRepository,
                                      MusicTrackRepository musicTrackRepository,
                                      BookRepository bookRepository,
                                      DocumentAdobePdfRepository documentAdobePdfRepository,
                                      DocumentAdobePhotoshopRepository documentAdobePhotoshopRepository,
                                      DocumentMicrosoftWordRepository documentMicrosoftWordRepository,
                                      DocumentMicrosoftWordOldRepository documentMicrosoftWordOldRepository,
                                      DocumentMicrosoftExcelRepository documentMicrosoftExcelRepository,
                                      DocumentMicrosoftExcelOldRepository documentMicrosoftExcelOldRepository,
                                      DocumentMicrosoftPowerpointRepository documentMicrosoftPowerpointRepository,
                                      DocumentMicrosoftPowerpointOldRepository documentMicrosoftPowerpointOldRepository,
                                      DocumentOpenTextRepository documentOpenTextRepository,
                                      DocumentOpenSpreadsheetRepository documentOpenSpreadsheetRepository,
                                      DocumentOpenPresentationRepository documentOpenPresentationRepository) {
        this.cacheService = cacheService;
        this.filesystemMainRepository = filesystemMainRepository;
        this.musicTrackRepository = musicTrackRepository;
        this.bookRepository = bookRepository;
        this.documentAdobePdfRepository = documentAdobePdfRepository;
        this.documentAdobePhotoshopRepository = documentAdobePhotoshopRepository;
        this.documentMicrosoftWordRepository = documentMicrosoftWordRepository;
        this.documentMicrosoftWordOldRepository = documentMicrosoftWordOldRepository;
        this.documentMicrosoftExcelRepository = documentMicrosoftExcelRepository;
        this.documentMicrosoftExcelOldRepository = documentMicrosoftExcelOldRepository;
        this.documentMicrosoftPowerpointRepository = documentMicrosoftPowerpointRepository;
        this.documentMicrosoftPowerpointOldRepository = documentMicrosoftPowerpointOldRepository;
        this.documentOpenTextRepository = documentOpenTextRepository;
        this.documentOpenSpreadsheetRepository = documentOpenSpreadsheetRepository;
        this.documentOpenPresentationRepository = documentOpenPresentationRepository;
    }

    @Override
    public MusicTrackEntity registerTrack(Map<String, Object> metadata, Path path) {
        FileSystemMainEntity fileSystemMainEntity = filesystemMainRepository.findByAccountEntity_Username(SecurityContextHolder.getContext().getAuthentication().getName());
        MusicTrackEntity trackEntity = new MusicTrackEntity(fileSystemMainEntity,
                                                            metadata.get(AudioConst.METADATA_AUDIO_TITLE).toString(),
                                                            metadata.get(AudioConst.METADATA_AUDIO_ALBUM).toString(),
                                                            metadata.get(AudioConst.METADATA_AUDIO_ARTIST).toString(),
                                                            path.toString());
        MusicTrackInfoEntity trackInfoEntity = new MusicTrackInfoEntity(trackEntity);
        trackInfoEntity.setPlaybackCount(0);
        trackInfoEntity.setSkipCount(0);
        trackInfoEntity.setLastPlayed(LocalDateTime.parse("1996-2-5T00:00:00.720"));
        MusicTrackInfoStaticEntity trackInfoStaticEntity = new MusicTrackInfoStaticEntity(Duration.ofMillis((Long) metadata.get(AudioConst.METADATA_AUDIO_DURATION)),
                                                                                          (Long) metadata.get(AudioConst.METADATA_AUDIO_SIZE),
                                                                                          metadata.get(AudioConst.METADATA_AUDIO_BITRATE).toString(),
                                                                                          metadata.get(AudioConst.METADATA_AUDIO_BIT_DEPTH).toString(),
                                                                                          metadata.get(AudioConst.METADATA_AUDIO_SAMPLE_RATE).toString(),
                                                                                          metadata.get(AudioConst.METADATA_AUDIO_MD5).toString(),
                                                                                          trackEntity);
        if (metadata.containsKey(AudioConst.METADATA_AUDIO_ARTWORK))
            trackInfoStaticEntity.setArtwork(metadata.get(AudioConst.METADATA_AUDIO_ARTWORK).toString());
        else trackInfoStaticEntity.setArtwork("");
        if (metadata.containsKey(AudioConst.METADATA_AUDIO_ALBUM_ARTIST))
            trackInfoStaticEntity.setAlbumArtist(metadata.get(AudioConst.METADATA_AUDIO_ALBUM_ARTIST).toString());
        else trackInfoStaticEntity.setAlbumArtist("");
        if (metadata.containsKey(AudioConst.METADATA_AUDIO_COMPOSER))
            trackInfoStaticEntity.setComposer(metadata.get(AudioConst.METADATA_AUDIO_COMPOSER).toString());
        else trackInfoStaticEntity.setComposer("");
        if (metadata.containsKey(AudioConst.METADATA_AUDIO_RELEASE_YEAR))
            trackInfoStaticEntity.setReleaseYear(metadata.get(AudioConst.METADATA_AUDIO_RELEASE_YEAR).toString());
        else trackInfoStaticEntity.setReleaseYear("");
        if (metadata.containsKey(AudioConst.METADATA_AUDIO_GENRE))
            trackInfoStaticEntity.setGenre(metadata.get(AudioConst.METADATA_AUDIO_GENRE).toString());
        else trackInfoStaticEntity.setGenre("");
        if (metadata.containsKey(AudioConst.METADATA_AUDIO_COMMENT))
            trackInfoStaticEntity.setComment(metadata.get(AudioConst.METADATA_AUDIO_COMMENT).toString());
        else trackInfoStaticEntity.setComment("");
        trackInfoStaticEntity.setKind(metadata.get(AudioConst.METADATA_AUDIO_KIND).toString());
        if (metadata.containsKey(AudioConst.METADATA_AUDIO_TRACK)) {
            if (metadata.get(AudioConst.METADATA_AUDIO_TRACK).toString().contains("/")) {
                String[] trackData = metadata.get(AudioConst.METADATA_AUDIO_TRACK).toString().split("/");
                trackInfoStaticEntity.setTrackNumber(Integer.valueOf(trackData[0]));
                trackInfoStaticEntity.setTrackTotal(Integer.valueOf(trackData[1]));
            } else {
                trackInfoStaticEntity.setTrackNumber(Integer.valueOf(metadata.get(AudioConst.METADATA_AUDIO_TRACK).toString()));
                trackInfoStaticEntity.setTrackTotal(0);
            }
        } else {
            trackInfoStaticEntity.setTrackNumber(0);
            trackInfoStaticEntity.setTrackTotal(0);
        }
        if (metadata.containsKey(AudioConst.METADATA_AUDIO_DISC)) {
            if (metadata.get(AudioConst.METADATA_AUDIO_DISC).toString().contains("/")) {
                String[] discData = metadata.get(AudioConst.METADATA_AUDIO_DISC).toString().split("/");
                trackInfoStaticEntity.setDiscNumber(Integer.valueOf(discData[0]));
                trackInfoStaticEntity.setDiscTotal(Integer.valueOf(discData[1]));
            } else {
                trackInfoStaticEntity.setDiscNumber(Integer.valueOf(metadata.get(AudioConst.METADATA_AUDIO_DISC).toString()));
                trackInfoStaticEntity.setDiscTotal(0);
            }
        } else {
            trackInfoStaticEntity.setDiscNumber(0);
            trackInfoStaticEntity.setDiscTotal(0);
        }
        trackInfoStaticEntity.setScore(5F);
        trackInfoStaticEntity.setLove(false);
        trackInfoStaticEntity.setDislike(false);
        trackEntity.setTrackInformation(trackInfoEntity);
        trackEntity.setTrackInformationStatic(trackInfoStaticEntity);
        return musicTrackRepository.saveAndFlush(trackEntity);
    }

    @Override
    public AnimeEpisodeEntity registerAnime(Map<String, String> metadata, Path path) {
        return null;
    }

    @Override
    public MovieEntity registerMovie(Map<String, String> metadata, Path path) {
        return null;
    }

    @Override
    public VideoEntity registerVideo(Map<String, String> metadata, Path path) {
        return null;
    }

    @Override
    public PhotoEntity registerPhoto(Map<String, String> metadata, Path path) {
        return null;
    }

    @Override
    public BookEntity registerBook(Map<String, Object> metadata, Path path) throws Exception {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        BookEntity bookEntity = new BookEntity(
                filesystemMainRepository.findByAccountEntity_Username(username),
                (String) metadata.get(FileConst.METADATA_BOOK_TITLE),
                (String) metadata.get(FileConst.METADATA_BOOK_AUTHOR),
                (String) metadata.get(FileConst.METADATA_BOOK_PATH));
        BookInfEntity bookInfEntity = new BookInfEntity(
                (Date) metadata.get(FileConst.METADATA_BOOK_CREATED),
                (Date) metadata.get(FileConst.METADATA_BOOK_MODIFIED),
                (Date) metadata.get(FileConst.METADATA_BOOK_LASTACCESSTIME),
                cacheService.cacheImage(ImageIO.read((InputStream) metadata.get(FileConst.METADATA_BOOK_COVER))).toString(),
                (Date) metadata.get(FileConst.METADATA_BOOK_DATE),
                (String) metadata.get(FileConst.METADATA_BOOK_DESCRIPTION),
                (String) metadata.get(FileConst.METADATA_BOOK_CONTRIBUTOR),
                (String) metadata.get(FileConst.METADATA_BOOK_PUBLISHER),
                (String) metadata.get(FileConst.METADATA_BOOK_RIGHT),
                (String) metadata.get(FileConst.METADATA_BOOK_LANGUAGE),
                (String) metadata.get(FileConst.METADATA_BOOK_TYPE),
                bookEntity
        );
        bookRepository.save(bookEntity);
        return bookEntity;
    }

    @Override
    public String registerDocument(Map<String, Object> metadata, Path path, String mimeType) throws Exception {
        switch (mimeType) {
            case FileConst.MIME_ADOBE_PDF:
                return registerAdobePdf(metadata, path);
            case FileConst.MIME_ADOBE_PHOTOSHOP:
                return registerAdobePhotoshop(metadata, path);
            case FileConst.MIME_MICROSOFT_WORD_OLD:
                return registerMicrosoftWordOld(metadata, path);
            case FileConst.MIME_MICROSOFT_EXCEL_OLD:
                return registerMicrosoftExcelOld(metadata, path);
            case FileConst.MIME_MICROSOFT_POWERPOINT_OLD:
                return registerMicrosoftPowerpointOld(metadata, path);
            case FileConst.MIME_MICROSOFT_WORD:
                return registerMicrosoftWord(metadata, path);
            case FileConst.MIME_MICROSOFT_EXCEL:
                return registerMicrosoftExcel(metadata, path);
            case FileConst.MIME_MICROSOFT_POWERPOINT:
                return registerMicrosoftPowerpoint(metadata, path);
            case FileConst.MIME_OPENDOCUMENT_TEXT:
                return registerOpendocumentText(metadata, path);
            case FileConst.MIME_OPENDOCUMENT_SPREADSHEET:
                return registerOpendocumentSpreadsheet(metadata, path);
            case FileConst.MIME_OPENDOCUMENT_PRESENTATION:
                return registerOpendocumentPresentation(metadata, path);
            default:
                return null;
        }
    }

    @Override
    public IllustrationEntity registerIllustration(Map<String, String> metadata, Path path) {
        return null;
    }

    private String registerAdobePdf(Map<String, Object> metadata, Path path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        DocumentAdobePdfEntity documentAdobePdfEntity = new DocumentAdobePdfEntity(
                (String) metadata.get(FileConst.METADATA_ADOBE_PDF_TITLE),
                (Date) metadata.get(FileConst.METADATA_ADOBE_PDF_CREATED),
                (Date) metadata.get(FileConst.METADATA_ADOBE_PDF_MODIFIED),
                (Date) metadata.get(FileConst.METADATA_ADOBE_PDF_LASTACCESSTIME),
                (String) metadata.get(FileConst.METADATA_ADOBE_PDF_PATH),
                (String) metadata.get(FileConst.METADATA_ADOBE_PDF_VERSION),
                (String) metadata.get(FileConst.METADATA_ADOBE_PDF_PRODUCER));
        documentAdobePdfRepository.save(documentAdobePdfEntity);
        return mapper.writeValueAsString(documentAdobePdfEntity);
    }

    private String registerAdobePhotoshop(Map<String, Object> metadata, Path path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        DocumentAdobePhotoshopEntity documentAdobePhotoshopEntity = new DocumentAdobePhotoshopEntity(
                (String) metadata.get(FileConst.METADATA_ADOBE_PHOTOSHOP_TITLE),
                (Date) metadata.get(FileConst.METADATA_ADOBE_PHOTOSHOP_CREATED),
                (Date) metadata.get(FileConst.METADATA_ADOBE_PHOTOSHOP_MODIFIED),
                (Date) metadata.get(FileConst.METADATA_ADOBE_PHOTOSHOP_LASTACCESSTIME),
                (String) metadata.get(FileConst.METADATA_ADOBE_PHOTOSHOP_PATH),
                (Integer) metadata.get(FileConst.METADATA_ADOBE_PHOTOSHOP_WIDTH),
                (Integer) metadata.get(FileConst.METADATA_ADOBE_PHOTOSHOP_HEIGHT),
                (String) metadata.get(FileConst.METADATA_ADOBE_PHOTOSHOP_COLORMODE),
                (Integer) metadata.get(FileConst.METADATA_ADOBE_PHOTOSHOP_BITSPERSAMPLE));
        documentAdobePhotoshopRepository.save(documentAdobePhotoshopEntity);
        return mapper.writeValueAsString(documentAdobePhotoshopEntity);
    }

    private String registerMicrosoftWordOld(Map<String, Object> metadata, Path path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        DocumentMicrosoftWordOldEntity documentMicrosoftWordOldEntity = new DocumentMicrosoftWordOldEntity(
                (String) metadata.get(FileConst.METADATA_MICROSOFT_WORD_OLD_TITLE),
                (Date) metadata.get(FileConst.METADATA_MICROSOFT_WORD_OLD_CREATED),
                (Date) metadata.get(FileConst.METADATA_MICROSOFT_WORD_OLD_MODIFIED),
                (Date) metadata.get(FileConst.METADATA_MICROSOFT_WORD_OLD_LASTACCESSTIME),
                (String) metadata.get(FileConst.METADATA_MICROSOFT_WORD_OLD_PATH),
                (String) metadata.get(FileConst.METADATA_MICROSOFT_WORD_OLD_KEYWORDS),
                (String) metadata.get(FileConst.METADATA_MICROSOFT_WORD_OLD_COMMENTS),
                (String) metadata.get(FileConst.METADATA_MICROSOFT_WORD_OLD_APPNAME),
                (Long) metadata.get(FileConst.METADATA_MICROSOFT_WORD_OLD_EDITTIME),
                (Integer) metadata.get(FileConst.METADATA_MICROSOFT_WORD_OLD_PAGECOUNT),
                (Integer) metadata.get(FileConst.METADATA_MICROSOFT_WORD_OLD_WORDCOUNT),
                (Integer) metadata.get(FileConst.METADATA_MICROSOFT_WORD_OLD_CHARCOUNT),
                (Integer) metadata.get(FileConst.METADATA_MICROSOFT_WORD_OLD_LINECOUNT),
                (Integer) metadata.get(FileConst.METADATA_MICROSOFT_WORD_OLD_PARCOUNT));
        documentMicrosoftWordOldRepository.save(documentMicrosoftWordOldEntity);
        return mapper.writeValueAsString(documentMicrosoftWordOldEntity);
    }

    private String registerMicrosoftExcelOld(Map<String, Object> metadata, Path path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        DocumentMicrosoftExcelOldEntity documentMicrosoftExcelOldEntity = new DocumentMicrosoftExcelOldEntity(
                (String) metadata.get(FileConst.METADATA_MICROSOFT_EXCEL_OLD_TITLE),
                (Date) metadata.get(FileConst.METADATA_MICROSOFT_EXCEL_OLD_CREATED),
                (Date) metadata.get(FileConst.METADATA_MICROSOFT_EXCEL_OLD_MODIFIED),
                (Date) metadata.get(FileConst.METADATA_MICROSOFT_EXCEL_OLD_LASTACCESSTIME),
                (String) metadata.get(FileConst.METADATA_MICROSOFT_EXCEL_OLD_PATH),
                (String) metadata.get(FileConst.METADATA_MICROSOFT_EXCEL_OLD_APPNAME),
                (Integer) metadata.get(FileConst.METADATA_MICROSOFT_EXCEL_OLD_DOCPARTS));
        documentMicrosoftExcelOldRepository.save(documentMicrosoftExcelOldEntity);
        return mapper.writeValueAsString(documentMicrosoftExcelOldEntity);
    }

    private String registerMicrosoftPowerpointOld(Map<String, Object> metadata, Path path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        DocumentMicrosoftPowerpointOldEntity documentMicrosoftPowerpointOldEntity = new DocumentMicrosoftPowerpointOldEntity(
                (String) metadata.get(FileConst.METADATA_MICROSOFT_POWERPOINT_OLD_TITLE),
                (Date) metadata.get(FileConst.METADATA_MICROSOFT_POWERPOINT_OLD_CREATED),
                (Date) metadata.get(FileConst.METADATA_MICROSOFT_POWERPOINT_OLD_MODIFIED),
                (Date) metadata.get(FileConst.METADATA_MICROSOFT_POWERPOINT_OLD_LASTACCESSTIME),
                (String) metadata.get(FileConst.METADATA_MICROSOFT_POWERPOINT_OLD_PATH),
                (String) metadata.get(FileConst.METADATA_MICROSOFT_POWERPOINT_OLD_APPNAME),
                (Long) metadata.get(FileConst.METADATA_MICROSOFT_POWERPOINT_OLD_EDITTIME),
                (Integer) metadata.get(FileConst.METADATA_MICROSOFT_POWERPOINT_OLD_WORDCOUNT),
                (Integer) metadata.get(FileConst.METADATA_MICROSOFT_POWERPOINT_OLD_BYTECOUNT),
                (Integer) metadata.get(FileConst.METADATA_MICROSOFT_POWERPOINT_OLD_PARCOUNT),
                (Integer) metadata.get(FileConst.METADATA_MICROSOFT_POWERPOINT_OLD_SLIDECOUNT),
                (Integer) metadata.get(FileConst.METADATA_MICROSOFT_POWERPOINT_OLD_NOTECOUNT),
                (Integer) metadata.get(FileConst.METADATA_MICROSOFT_POWERPOINT_OLD_HIDDENCOUNT),
                (Integer) metadata.get(FileConst.METADATA_MICROSOFT_POWERPOINT_OLD_MMCLIPCOUNT),
                (String) metadata.get(FileConst.METADATA_MICROSOFT_POWERPOINT_OLD_PRESFORMAT));
        documentMicrosoftPowerpointOldRepository.save(documentMicrosoftPowerpointOldEntity);
        return mapper.writeValueAsString(documentMicrosoftPowerpointOldEntity);
    }

    private String registerMicrosoftWord(Map<String, Object> metadata, Path path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        DocumentMicrosoftWordEntity documentMicrosoftWordEntity = new DocumentMicrosoftWordEntity(
                (String) metadata.get(FileConst.METADATA_MICROSOFT_WORD_TITLE),
                (Date) metadata.get(FileConst.METADATA_MICROSOFT_WORD_CREATED),
                (Date) metadata.get(FileConst.METADATA_MICROSOFT_WORD_MODIFIED),
                (Date) metadata.get(FileConst.METADATA_MICROSOFT_WORD_LASTACCESSTIME),
                (String) metadata.get(FileConst.METADATA_MICROSOFT_WORD_PATH),
                (String) metadata.get(FileConst.METADATA_MICROSOFT_WORD_APPLICATION),
                (String) metadata.get(FileConst.METADATA_MICROSOFT_WORD_APPVERSION),
                (Integer) metadata.get(FileConst.METADATA_MICROSOFT_WORD_CHARACTERS),
                (Integer) metadata.get(FileConst.METADATA_MICROSOFT_WORD_CHARACTERSWITHSPACES),
                (Integer) metadata.get(FileConst.METADATA_MICROSOFT_WORD_LINES),
                (Integer) metadata.get(FileConst.METADATA_MICROSOFT_WORD_PAGES),
                (Integer) metadata.get(FileConst.METADATA_MICROSOFT_WORD_PARAGRAPHS));
        documentMicrosoftWordRepository.save(documentMicrosoftWordEntity);
        return mapper.writeValueAsString(documentMicrosoftWordEntity);
    }

    private String registerMicrosoftExcel(Map<String, Object> metadata, Path path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        DocumentMicrosoftExcelEntity documentMicrosoftExcelEntity = new DocumentMicrosoftExcelEntity(
                (String) metadata.get(FileConst.METADATA_MICROSOFT_EXCEL_TITLE),
                (Date) metadata.get(FileConst.METADATA_MICROSOFT_EXCEL_CREATED),
                (Date) metadata.get(FileConst.METADATA_MICROSOFT_EXCEL_MODIFIED),
                (Date) metadata.get(FileConst.METADATA_MICROSOFT_EXCEL_LASTACCESSTIME),
                (String) metadata.get(FileConst.METADATA_MICROSOFT_EXCEL_PATH),
                (String) metadata.get(FileConst.METADATA_MICROSOFT_EXCEL_APPLICATION),
                (String) metadata.get(FileConst.METADATA_MICROSOFT_EXCEL_APPVERSION),
                (Integer) metadata.get(FileConst.METADATA_MICROSOFT_EXCEL_CHARACTERS),
                (Integer) metadata.get(FileConst.METADATA_MICROSOFT_EXCEL_CHARACTERSWITHSPACES),
                (Integer) metadata.get(FileConst.METADATA_MICROSOFT_EXCEL_LINES),
                (Integer) metadata.get(FileConst.METADATA_MICROSOFT_EXCEL_PAGES),
                (Integer) metadata.get(FileConst.METADATA_MICROSOFT_EXCEL_PARAGRAPHS));
        documentMicrosoftExcelRepository.save(documentMicrosoftExcelEntity);
        return mapper.writeValueAsString(documentMicrosoftExcelEntity);
    }

    private String registerMicrosoftPowerpoint(Map<String, Object> metadata, Path path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        DocumentMicrosoftPowerpointEntity documentMicrosoftPowerpointEntity = new DocumentMicrosoftPowerpointEntity(
                (String) metadata.get(FileConst.METADATA_MICROSOFT_POWERPOINT_TITLE),
                (Date) metadata.get(FileConst.METADATA_MICROSOFT_POWERPOINT_CREATED),
                (Date) metadata.get(FileConst.METADATA_MICROSOFT_POWERPOINT_MODIFIED),
                (Date) metadata.get(FileConst.METADATA_MICROSOFT_POWERPOINT_LASTACCESSTIME),
                (String) metadata.get(FileConst.METADATA_MICROSOFT_POWERPOINT_PATH),
                (String) metadata.get(FileConst.METADATA_MICROSOFT_POWERPOINT_APPLICATION),
                (String) metadata.get(FileConst.METADATA_MICROSOFT_POWERPOINT_APPVERSION),
                (Integer) metadata.get(FileConst.METADATA_MICROSOFT_POWERPOINT_CHARACTERS),
                (Integer) metadata.get(FileConst.METADATA_MICROSOFT_POWERPOINT_CHARACTERSWITHSPACES),
                (Integer) metadata.get(FileConst.METADATA_MICROSOFT_POWERPOINT_LINES),
                (Integer) metadata.get(FileConst.METADATA_MICROSOFT_POWERPOINT_PAGES),
                (Integer) metadata.get(FileConst.METADATA_MICROSOFT_POWERPOINT_PARAGRAPHS),
                (String) metadata.get(FileConst.METADATA_MICROSOFT_POWERPOINT_PRESENTATIONFORMAT));
        documentMicrosoftPowerpointRepository.save(documentMicrosoftPowerpointEntity);
        return mapper.writeValueAsString(documentMicrosoftPowerpointEntity);
    }

    private String registerOpendocumentText(Map<String, Object> metadata, Path path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        DocumentOpenTextEntity documentOpenTextEntity = new DocumentOpenTextEntity(
                (String) metadata.get(FileConst.METADATA_OPENDOCUMENT_TEXT_TITLE),
                (Date) metadata.get(FileConst.METADATA_OPENDOCUMENT_TEXT_CREATED),
                (Date) metadata.get(FileConst.METADATA_OPENDOCUMENT_TEXT_MODIFIED),
                (Date) metadata.get(FileConst.METADATA_OPENDOCUMENT_TEXT_LASTACCESSTIME),
                (String) metadata.get(FileConst.METADATA_OPENDOCUMENT_TEXT_PATH),
                (Integer) metadata.get(FileConst.METADATA_OPENDOCUMENT_TEXT_WORDCOUNT),
                (Integer) metadata.get(FileConst.METADATA_OPENDOCUMENT_TEXT_CHARACTERCOUNT),
                (Integer) metadata.get(FileConst.METADATA_OPENDOCUMENT_TEXT_IMAGECOUNT),
                (Integer) metadata.get(FileConst.METADATA_OPENDOCUMENT_TEXT_PARCOUNT),
                (Integer) metadata.get(FileConst.METADATA_OPENDOCUMENT_TEXT_TABLECOUNT),
                (Integer) metadata.get(FileConst.METADATA_OPENDOCUMENT_TEXT_PAGECOUNT));
        documentOpenTextRepository.save(documentOpenTextEntity);
        return mapper.writeValueAsString(documentOpenTextEntity);
    }

    private String registerOpendocumentSpreadsheet(Map<String, Object> metadata, Path path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        DocumentOpenSpreadsheetEntity documentOpenSpreadsheetEntity = new DocumentOpenSpreadsheetEntity(
                (String) metadata.get(FileConst.METADATA_OPENDOCUMENT_SPREADSHEET_TITLE),
                (Date) metadata.get(FileConst.METADATA_OPENDOCUMENT_SPREADSHEET_CREATED),
                (Date) metadata.get(FileConst.METADATA_OPENDOCUMENT_SPREADSHEET_MODIFIED),
                (Date) metadata.get(FileConst.METADATA_OPENDOCUMENT_SPREADSHEET_LASTACCESSTIME),
                (String) metadata.get(FileConst.METADATA_OPENDOCUMENT_SPREADSHEET_PATH));
        documentOpenSpreadsheetRepository.save(documentOpenSpreadsheetEntity);
        return mapper.writeValueAsString(documentOpenSpreadsheetEntity);
    }

    private String registerOpendocumentPresentation(Map<String, Object> metadata, Path path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        DocumentOpenPresentationEntity documentOpenPresentationEntity = new DocumentOpenPresentationEntity(
                (String) metadata.get(FileConst.METADATA_OPENDOCUMENT_PRESENTATION_TITLE),
                (Date) metadata.get(FileConst.METADATA_OPENDOCUMENT_PRESENTATION_CREATED),
                (Date) metadata.get(FileConst.METADATA_OPENDOCUMENT_PRESENTATION_MODIFIED),
                (Date) metadata.get(FileConst.METADATA_OPENDOCUMENT_PRESENTATION_LASTACCESSTIME),
                (String) metadata.get(FileConst.METADATA_OPENDOCUMENT_PRESENTATION_PATH));
        documentOpenPresentationRepository.save(documentOpenPresentationEntity);
        return mapper.writeValueAsString(documentOpenPresentationEntity);
    }
}
