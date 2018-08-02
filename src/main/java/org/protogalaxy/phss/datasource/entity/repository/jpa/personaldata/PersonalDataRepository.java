package org.protogalaxy.phss.datasource.entity.repository.jpa.personaldata;

import org.protogalaxy.phss.datasource.entity.core.personaldata.PersonalDataEntity;
import org.springframework.data.repository.CrudRepository;

public interface PersonalDataRepository extends CrudRepository<PersonalDataEntity, Integer> {
}
