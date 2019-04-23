package org.protogalaxy.phss.datasource.repository.jpa.thirdparty;

import org.protogalaxy.phss.datasource.entity.thirdparty.BangumiOAuth2Entity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BangumiOAuth2Repository extends CrudRepository<BangumiOAuth2Entity, UUID> {
}
