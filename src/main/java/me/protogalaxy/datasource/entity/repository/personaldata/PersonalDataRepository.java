package me.protogalaxy.datasource.entity.repository.personaldata;

import me.protogalaxy.datasource.entity.core.personaldata.PersonalDataEntity;
import org.springframework.data.repository.CrudRepository;

public interface PersonalDataRepository extends CrudRepository<PersonalDataEntity, Integer> {
}
