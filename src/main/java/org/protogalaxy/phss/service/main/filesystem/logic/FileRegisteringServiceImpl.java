package org.protogalaxy.phss.service.main.filesystem.logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.protogalaxy.phss.component.file.FileConsts;
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
import org.protogalaxy.phss.datasource.repository.jpa.filesystem.book.BookInfRepository;
import org.protogalaxy.phss.datasource.repository.jpa.filesystem.book.BookRepository;
import org.protogalaxy.phss.datasource.repository.jpa.filesystem.main.FilesystemMainRepository;
import org.protogalaxy.phss.datasource.repository.mongodb.document.*;
import org.protogalaxy.phss.service.main.filesystem.io.CacheServiceImpl;
import org.protogalaxy.phss.service.interfaces.filesystem.io.CacheService;
import org.protogalaxy.phss.service.interfaces.filesystem.observer.FileRegisteringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Date;
import java.util.Map;

@Service
public class FileRegisteringServiceImpl implements FileRegisteringService {
    //Services
    private final CacheService cacheService;


    //Database core repositories
    private final FilesystemMainRepository filesystemMainRepository;


    //Database database repositories
    private final MusicTrackRepository musicTrackRepository;
    private final BookRepository bookRepository;
    private final BookInfRepository bookInfRepository;
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
    public FileRegisteringServiceImpl(CacheServiceImpl cachingService,
                                      FilesystemMainRepository filesystemMainRepository,
                                      MusicTrackRepository musicTrackRepository,
                                      BookRepository bookRepository,
                                      BookInfRepository bookInfRepository,
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
        this.cacheService = cachingService;
        this.filesystemMainRepository = filesystemMainRepository;
        this.musicTrackRepository = musicTrackRepository;
        this.bookRepository = bookRepository;
        this.bookInfRepository = bookInfRepository;
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
    public MusicTrackEntity registerTrack(String username, Map<String, Object> metadata, Path path) throws Exception {
        MusicTrackEntity trackEntity = new MusicTrackEntity();
        musicTrackRepository.save(trackEntity);
        return trackEntity;
    }

    @Override
    public AnimeEpisodeEntity registerAnime(String username, Map<String, String> metadata, Path path) throws Exception {
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
    public BookEntity registerBook(String username, Map<String, Object> metadata, Path path) throws Exception {
        BookEntity bookEntity = new BookEntity(
                filesystemMainRepository.findByUserEntity_Username(username),
                (String) metadata.get(FileConsts.METADATA_BOOK_TITLE),
                (String) metadata.get(FileConsts.METADATA_BOOK_AUTHOR),
                (String) metadata.get(FileConsts.METADATA_BOOK_PATH));
        BookInfEntity bookInfEntity = new BookInfEntity(
                (Date) metadata.get(FileConsts.METADATA_BOOK_CREATED),
                (Date) metadata.get(FileConsts.METADATA_BOOK_MODIFIED),
                (Date) metadata.get(FileConsts.METADATA_BOOK_LASTACCESSTIME),
                cacheService.cacheImage(username, ImageIO.read((InputStream) metadata.get(FileConsts.METADATA_BOOK_COVER))).toString(),
                (Date) metadata.get(FileConsts.METADATA_BOOK_DATE),
                (String) metadata.get(FileConsts.METADATA_BOOK_DESCRIPTION),
                (String) metadata.get(FileConsts.METADATA_BOOK_CONTRIBUTOR),
                (String) metadata.get(FileConsts.METADATA_BOOK_PUBLISHER),
                (String) metadata.get(FileConsts.METADATA_BOOK_RIGHT),
                (String) metadata.get(FileConsts.METADATA_BOOK_LANGUAGE),
                (String) metadata.get(FileConsts.METADATA_BOOK_TYPE),
                bookEntity
        );
        bookRepository.save(bookEntity);
        bookInfRepository.save(bookInfEntity);
        return bookEntity;
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
            default:
                return null;
        }
    }

    @Override
    public IllustrationEntity registerIllustration(String username, Map<String, String> metadata, Path path) throws Exception {
        return null;
    }

    private String registerAdobePdf(String username, Map<String, Object> metadata, Path path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        DocumentAdobePdfEntity documentAdobePdfEntity = new DocumentAdobePdfEntity(
                (String) metadata.get(FileConsts.METADATA_ADOBE_PDF_TITLE),
                (Date) metadata.get(FileConsts.METADATA_ADOBE_PDF_CREATED),
                (Date) metadata.get(FileConsts.METADATA_ADOBE_PDF_MODIFIED),
                (Date) metadata.get(FileConsts.METADATA_ADOBE_PDF_LASTACCESSTIME),
                (String) metadata.get(FileConsts.METADATA_ADOBE_PDF_PATH),
                (String) metadata.get(FileConsts.METADATA_ADOBE_PDF_VERSION),
                (String) metadata.get(FileConsts.METADATA_ADOBE_PDF_PRODUCER));
        documentAdobePdfRepository.save(documentAdobePdfEntity);
        return mapper.writeValueAsString(documentAdobePdfEntity);
    }

    private String registerAdobePhotoshop(String username, Map<String, Object> metadata, Path path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        DocumentAdobePhotoshopEntity documentAdobePhotoshopEntity = new DocumentAdobePhotoshopEntity(
                (String) metadata.get(FileConsts.METADATA_ADOBE_PHOTOSHOP_TITLE),
                (Date) metadata.get(FileConsts.METADATA_ADOBE_PHOTOSHOP_CREATED),
                (Date) metadata.get(FileConsts.METADATA_ADOBE_PHOTOSHOP_MODIFIED),
                (Date) metadata.get(FileConsts.METADATA_ADOBE_PHOTOSHOP_LASTACCESSTIME),
                (String) metadata.get(FileConsts.METADATA_ADOBE_PHOTOSHOP_PATH),
                (Integer) metadata.get(FileConsts.METADATA_ADOBE_PHOTOSHOP_WIDTH),
                (Integer) metadata.get(FileConsts.METADATA_ADOBE_PHOTOSHOP_HEIGHT),
                (String) metadata.get(FileConsts.METADATA_ADOBE_PHOTOSHOP_COLORMODE),
                (Integer) metadata.get(FileConsts.METADATA_ADOBE_PHOTOSHOP_BITSPERSAMPLE));
        documentAdobePhotoshopRepository.save(documentAdobePhotoshopEntity);
        return mapper.writeValueAsString(documentAdobePhotoshopEntity);
    }

    private String registerMicrosoftWordOld(String username, Map<String, Object> metadata, Path path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        DocumentMicrosoftWordOldEntity documentMicrosoftWordOldEntity = new DocumentMicrosoftWordOldEntity(
                (String) metadata.get(FileConsts.METADATA_MICROSOFT_WORD_OLD_TITLE),
                (Date) metadata.get(FileConsts.METADATA_MICROSOFT_WORD_OLD_CREATED),
                (Date) metadata.get(FileConsts.METADATA_MICROSOFT_WORD_OLD_MODIFIED),
                (Date) metadata.get(FileConsts.METADATA_MICROSOFT_WORD_OLD_LASTACCESSTIME),
                (String) metadata.get(FileConsts.METADATA_MICROSOFT_WORD_OLD_PATH),
                (String) metadata.get(FileConsts.METADATA_MICROSOFT_WORD_OLD_KEYWORDS),
                (String) metadata.get(FileConsts.METADATA_MICROSOFT_WORD_OLD_COMMENTS),
                (String) metadata.get(FileConsts.METADATA_MICROSOFT_WORD_OLD_APPNAME),
                (Long) metadata.get(FileConsts.METADATA_MICROSOFT_WORD_OLD_EDITTIME),
                (Integer) metadata.get(FileConsts.METADATA_MICROSOFT_WORD_OLD_PAGECOUNT),
                (Integer) metadata.get(FileConsts.METADATA_MICROSOFT_WORD_OLD_WORDCOUNT),
                (Integer) metadata.get(FileConsts.METADATA_MICROSOFT_WORD_OLD_CHARCOUNT),
                (Integer) metadata.get(FileConsts.METADATA_MICROSOFT_WORD_OLD_LINECOUNT),
                (Integer) metadata.get(FileConsts.METADATA_MICROSOFT_WORD_OLD_PARCOUNT));
        documentMicrosoftWordOldRepository.save(documentMicrosoftWordOldEntity);
        return mapper.writeValueAsString(documentMicrosoftWordOldEntity);
    }

    private String registerMicrosoftExcelOld(String username, Map<String, Object> metadata, Path path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        DocumentMicrosoftExcelOldEntity documentMicrosoftExcelOldEntity = new DocumentMicrosoftExcelOldEntity(
                (String) metadata.get(FileConsts.METADATA_MICROSOFT_EXCEL_OLD_TITLE),
                (Date) metadata.get(FileConsts.METADATA_MICROSOFT_EXCEL_OLD_CREATED),
                (Date) metadata.get(FileConsts.METADATA_MICROSOFT_EXCEL_OLD_MODIFIED),
                (Date) metadata.get(FileConsts.METADATA_MICROSOFT_EXCEL_OLD_LASTACCESSTIME),
                (String) metadata.get(FileConsts.METADATA_MICROSOFT_EXCEL_OLD_PATH),
                (String) metadata.get(FileConsts.METADATA_MICROSOFT_EXCEL_OLD_APPNAME),
                (Integer) metadata.get(FileConsts.METADATA_MICROSOFT_EXCEL_OLD_DOCPARTS));
        documentMicrosoftExcelOldRepository.save(documentMicrosoftExcelOldEntity);
        return mapper.writeValueAsString(documentMicrosoftExcelOldEntity);
    }

    private String registerMicrosoftPowerpointOld(String username, Map<String, Object> metadata, Path path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        DocumentMicrosoftPowerpointOldEntity documentMicrosoftPowerpointOldEntity = new DocumentMicrosoftPowerpointOldEntity(
                (String) metadata.get(FileConsts.METADATA_MICROSOFT_POWERPOINT_OLD_TITLE),
                (Date) metadata.get(FileConsts.METADATA_MICROSOFT_POWERPOINT_OLD_CREATED),
                (Date) metadata.get(FileConsts.METADATA_MICROSOFT_POWERPOINT_OLD_MODIFIED),
                (Date) metadata.get(FileConsts.METADATA_MICROSOFT_POWERPOINT_OLD_LASTACCESSTIME),
                (String) metadata.get(FileConsts.METADATA_MICROSOFT_POWERPOINT_OLD_PATH),
                (String) metadata.get(FileConsts.METADATA_MICROSOFT_POWERPOINT_OLD_APPNAME),
                (Long) metadata.get(FileConsts.METADATA_MICROSOFT_POWERPOINT_OLD_EDITTIME),
                (Integer) metadata.get(FileConsts.METADATA_MICROSOFT_POWERPOINT_OLD_WORDCOUNT),
                (Integer) metadata.get(FileConsts.METADATA_MICROSOFT_POWERPOINT_OLD_BYTECOUNT),
                (Integer) metadata.get(FileConsts.METADATA_MICROSOFT_POWERPOINT_OLD_PARCOUNT),
                (Integer) metadata.get(FileConsts.METADATA_MICROSOFT_POWERPOINT_OLD_SLIDECOUNT),
                (Integer) metadata.get(FileConsts.METADATA_MICROSOFT_POWERPOINT_OLD_NOTECOUNT),
                (Integer) metadata.get(FileConsts.METADATA_MICROSOFT_POWERPOINT_OLD_HIDDENCOUNT),
                (Integer) metadata.get(FileConsts.METADATA_MICROSOFT_POWERPOINT_OLD_MMCLIPCOUNT),
                (String) metadata.get(FileConsts.METADATA_MICROSOFT_POWERPOINT_OLD_PRESFORMAT));
        documentMicrosoftPowerpointOldRepository.save(documentMicrosoftPowerpointOldEntity);
        return mapper.writeValueAsString(documentMicrosoftPowerpointOldEntity);
    }

    private String registerMicrosoftWord(String username, Map<String, Object> metadata, Path path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        DocumentMicrosoftWordEntity documentMicrosoftWordEntity = new DocumentMicrosoftWordEntity(
                (String) metadata.get(FileConsts.METADATA_MICROSOFT_WORD_TITLE),
                (Date) metadata.get(FileConsts.METADATA_MICROSOFT_WORD_CREATED),
                (Date) metadata.get(FileConsts.METADATA_MICROSOFT_WORD_MODIFIED),
                (Date) metadata.get(FileConsts.METADATA_MICROSOFT_WORD_LASTACCESSTIME),
                (String) metadata.get(FileConsts.METADATA_MICROSOFT_WORD_PATH),
                (String) metadata.get(FileConsts.METADATA_MICROSOFT_WORD_APPLICATION),
                (String) metadata.get(FileConsts.METADATA_MICROSOFT_WORD_APPVERSION),
                (Integer) metadata.get(FileConsts.METADATA_MICROSOFT_WORD_CHARACTERS),
                (Integer) metadata.get(FileConsts.METADATA_MICROSOFT_WORD_CHARACTERSWITHSPACES),
                (Integer) metadata.get(FileConsts.METADATA_MICROSOFT_WORD_LINES),
                (Integer) metadata.get(FileConsts.METADATA_MICROSOFT_WORD_PAGES),
                (Integer) metadata.get(FileConsts.METADATA_MICROSOFT_WORD_PARAGRAPHS));
        documentMicrosoftWordRepository.save(documentMicrosoftWordEntity);
        return mapper.writeValueAsString(documentMicrosoftWordEntity);
    }

    private String registerMicrosoftExcel(String username, Map<String, Object> metadata, Path path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        DocumentMicrosoftExcelEntity documentMicrosoftExcelEntity = new DocumentMicrosoftExcelEntity(
                (String) metadata.get(FileConsts.METADATA_MICROSOFT_EXCEL_TITLE),
                (Date) metadata.get(FileConsts.METADATA_MICROSOFT_EXCEL_CREATED),
                (Date) metadata.get(FileConsts.METADATA_MICROSOFT_EXCEL_MODIFIED),
                (Date) metadata.get(FileConsts.METADATA_MICROSOFT_EXCEL_LASTACCESSTIME),
                (String) metadata.get(FileConsts.METADATA_MICROSOFT_EXCEL_PATH),
                (String) metadata.get(FileConsts.METADATA_MICROSOFT_EXCEL_APPLICATION),
                (String) metadata.get(FileConsts.METADATA_MICROSOFT_EXCEL_APPVERSION),
                (Integer) metadata.get(FileConsts.METADATA_MICROSOFT_EXCEL_CHARACTERS),
                (Integer) metadata.get(FileConsts.METADATA_MICROSOFT_EXCEL_CHARACTERSWITHSPACES),
                (Integer) metadata.get(FileConsts.METADATA_MICROSOFT_EXCEL_LINES),
                (Integer) metadata.get(FileConsts.METADATA_MICROSOFT_EXCEL_PAGES),
                (Integer) metadata.get(FileConsts.METADATA_MICROSOFT_EXCEL_PARAGRAPHS));
        documentMicrosoftExcelRepository.save(documentMicrosoftExcelEntity);
        return mapper.writeValueAsString(documentMicrosoftExcelEntity);
    }

    private String registerMicrosoftPowerpoint(String username, Map<String, Object> metadata, Path path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        DocumentMicrosoftPowerpointEntity documentMicrosoftPowerpointEntity = new DocumentMicrosoftPowerpointEntity(
                (String) metadata.get(FileConsts.METADATA_MICROSOFT_POWERPOINT_TITLE),
                (Date) metadata.get(FileConsts.METADATA_MICROSOFT_POWERPOINT_CREATED),
                (Date) metadata.get(FileConsts.METADATA_MICROSOFT_POWERPOINT_MODIFIED),
                (Date) metadata.get(FileConsts.METADATA_MICROSOFT_POWERPOINT_LASTACCESSTIME),
                (String) metadata.get(FileConsts.METADATA_MICROSOFT_POWERPOINT_PATH),
                (String) metadata.get(FileConsts.METADATA_MICROSOFT_POWERPOINT_APPLICATION),
                (String) metadata.get(FileConsts.METADATA_MICROSOFT_POWERPOINT_APPVERSION),
                (Integer) metadata.get(FileConsts.METADATA_MICROSOFT_POWERPOINT_CHARACTERS),
                (Integer) metadata.get(FileConsts.METADATA_MICROSOFT_POWERPOINT_CHARACTERSWITHSPACES),
                (Integer) metadata.get(FileConsts.METADATA_MICROSOFT_POWERPOINT_LINES),
                (Integer) metadata.get(FileConsts.METADATA_MICROSOFT_POWERPOINT_PAGES),
                (Integer) metadata.get(FileConsts.METADATA_MICROSOFT_POWERPOINT_PARAGRAPHS),
                (String) metadata.get(FileConsts.METADATA_MICROSOFT_POWERPOINT_PRESENTATIONFORMAT));
        documentMicrosoftPowerpointRepository.save(documentMicrosoftPowerpointEntity);
        return mapper.writeValueAsString(documentMicrosoftPowerpointEntity);
    }

    private String registerOpendocumentText(String username, Map<String, Object> metadata, Path path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        DocumentOpenTextEntity documentOpenTextEntity = new DocumentOpenTextEntity(
                (String) metadata.get(FileConsts.METADATA_OPENDOCUMENT_TEXT_TITLE),
                (Date) metadata.get(FileConsts.METADATA_OPENDOCUMENT_TEXT_CREATED),
                (Date) metadata.get(FileConsts.METADATA_OPENDOCUMENT_TEXT_MODIFIED),
                (Date) metadata.get(FileConsts.METADATA_OPENDOCUMENT_TEXT_LASTACCESSTIME),
                (String) metadata.get(FileConsts.METADATA_OPENDOCUMENT_TEXT_PATH),
                (Integer) metadata.get(FileConsts.METADATA_OPENDOCUMENT_TEXT_WORDCOUNT),
                (Integer) metadata.get(FileConsts.METADATA_OPENDOCUMENT_TEXT_CHARACTERCOUNT),
                (Integer) metadata.get(FileConsts.METADATA_OPENDOCUMENT_TEXT_IMAGECOUNT),
                (Integer) metadata.get(FileConsts.METADATA_OPENDOCUMENT_TEXT_PARCOUNT),
                (Integer) metadata.get(FileConsts.METADATA_OPENDOCUMENT_TEXT_TABLECOUNT),
                (Integer) metadata.get(FileConsts.METADATA_OPENDOCUMENT_TEXT_PAGECOUNT));
        documentOpenTextRepository.save(documentOpenTextEntity);
        return mapper.writeValueAsString(documentOpenTextEntity);
    }

    private String registerOpendocumentSpreadsheet(String username, Map<String, Object> metadata, Path path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        DocumentOpenSpreadsheetEntity documentOpenSpreadsheetEntity = new DocumentOpenSpreadsheetEntity(
                (String) metadata.get(FileConsts.METADATA_OPENDOCUMENT_SPREADSHEET_TITLE),
                (Date) metadata.get(FileConsts.METADATA_OPENDOCUMENT_SPREADSHEET_CREATED),
                (Date) metadata.get(FileConsts.METADATA_OPENDOCUMENT_SPREADSHEET_MODIFIED),
                (Date) metadata.get(FileConsts.METADATA_OPENDOCUMENT_SPREADSHEET_LASTACCESSTIME),
                (String) metadata.get(FileConsts.METADATA_OPENDOCUMENT_SPREADSHEET_PATH));
        documentOpenSpreadsheetRepository.save(documentOpenSpreadsheetEntity);
        return mapper.writeValueAsString(documentOpenSpreadsheetEntity);
    }

    private String registerOpendocumentPresentation(String username, Map<String, Object> metadata, Path path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        DocumentOpenPresentationEntity documentOpenPresentationEntity = new DocumentOpenPresentationEntity(
                (String) metadata.get(FileConsts.METADATA_OPENDOCUMENT_PRESENTATION_TITLE),
                (Date) metadata.get(FileConsts.METADATA_OPENDOCUMENT_PRESENTATION_CREATED),
                (Date) metadata.get(FileConsts.METADATA_OPENDOCUMENT_PRESENTATION_MODIFIED),
                (Date) metadata.get(FileConsts.METADATA_OPENDOCUMENT_PRESENTATION_LASTACCESSTIME),
                (String) metadata.get(FileConsts.METADATA_OPENDOCUMENT_PRESENTATION_PATH));
        documentOpenPresentationRepository.save(documentOpenPresentationEntity);
        return mapper.writeValueAsString(documentOpenPresentationEntity);
    }
}
