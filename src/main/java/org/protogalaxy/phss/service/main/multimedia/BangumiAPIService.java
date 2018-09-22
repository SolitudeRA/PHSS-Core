package org.protogalaxy.phss.service.main.multimedia;

import org.protogalaxy.phss.datasource.entity.filesystem.anime.AnimeFirmEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.anime.AnimeSeiyuuEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.anime.AnimeStaffEntity;


public interface BangumiAPIService {

    AnimeStaffEntity retrieveStaff();

    AnimeFirmEntity retrieveFirm();

    AnimeSeiyuuEntity retrieveSeiyuu();
}
