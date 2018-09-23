package org.protogalaxy.phss.service.main.multimedia;

import org.protogalaxy.phss.datasource.entity.filesystem.anime.*;


public interface BangumiAPIService {
    AnimeMainEntity searchAnime();

    AnimeCharacterEntity searchCharacter();

    AnimeFirmEntity searchFirm();

    AnimeSeiyuuEntity searchSeiyuu();

    AnimeStaffEntity searchStaff();

    AnimeMainEntity retrieveAnime();

    AnimeCharacterEntity retrieveCharacter();

    AnimeFirmEntity retrieveFirm();

    AnimeSeiyuuEntity retrieveSeiyuu();

    AnimeStaffEntity retrieveStaff();
}
