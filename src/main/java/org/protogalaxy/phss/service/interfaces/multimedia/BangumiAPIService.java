package org.protogalaxy.phss.service.interfaces.multimedia;

import org.protogalaxy.phss.datasource.entity.filesystem.anime.*;


public interface BangumiAPIService {
    /**
     * Search anime information by keyword
     *
     * @param keyword Search keyword
     * @return AnimeMainEntity with information
     */
    AnimeMainEntity searchAnime(String keyword);

    /**
     * Search character information by keyword
     *
     * @param keyword Search keyword
     * @return AnimeCharacterEntity with information
     */
    AnimeCharacterEntity searchCharacter(String keyword);

    /**
     * Search firm information by keyword
     *
     * @param keyword Search keyword
     * @return AnimeFirmEntity with information
     */
    AnimeFirmEntity searchFirm(String keyword);

    /**
     * Search seiyuu information by keyword
     *
     * @param keyword Search keyword
     * @return AnimeSeiyuuEntity with information
     */
    AnimeSeiyuuEntity searchSeiyuu(String keyword);

    /**
     * Search staff information by keyword
     *
     * @param keyword Search keyword
     * @return AnimeStaffEntity with information
     */
    AnimeStaffEntity searchStaff(String keyword);

    /**
     * Retrieve anime information by Bangumi ID
     *
     * @param bangumiId Bangumi object ID
     * @return AnimeMainEntity with information
     */
    AnimeMainEntity retrieveAnime(int bangumiId);

    /**
     * Retrieve character information by Bangumi ID
     *
     * @param bangumiId Bangumi object ID
     * @return AnimeCharacterEntity with information
     */
    AnimeCharacterEntity retrieveCharacter(int bangumiId);

    /**
     * Retrieve firm information by Bangumi ID
     *
     * @param bangumiId Bangumi object ID
     * @return AnimeFirmEntity with information
     */
    AnimeFirmEntity retrieveFirm(int bangumiId);

    /**
     * Retrieve seiyuu information by Bangumi ID
     *
     * @param bangumiId Bangumi object ID
     * @return AnimeSeiyuuEntity with information
     */
    AnimeSeiyuuEntity retrieveSeiyuu(int bangumiId);

    /**
     * Retrieve staff information by Bangumi ID
     *
     * @param bangumiId Bangumi object ID
     * @return AnimeStaffEntity with information
     */
    AnimeStaffEntity retrieveStaff(int bangumiId);
}
