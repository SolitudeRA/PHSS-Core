package org.protogalaxy.phss.datasource.entity.repository.personaldata.calender;

import org.protogalaxy.phss.datasource.entity.core.personaldata.calender.CalenderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface CalenderRepository extends Repository<CalenderEntity, Integer>, CrudRepository<CalenderEntity, Integer> {
}
