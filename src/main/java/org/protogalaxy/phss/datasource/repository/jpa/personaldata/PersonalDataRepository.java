package org.protogalaxy.phss.datasource.repository.jpa.personaldata;

import org.protogalaxy.phss.datasource.entity.personaldata.PersonalDataEntity;
import org.springframework.data.repository.CrudRepository;

public interface PersonalDataRepository extends CrudRepository<PersonalDataEntity, Integer> {
}
