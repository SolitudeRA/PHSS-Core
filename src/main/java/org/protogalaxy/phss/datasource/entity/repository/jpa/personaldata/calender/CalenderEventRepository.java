package org.protogalaxy.phss.datasource.entity.repository.jpa.personaldata.calender;

import org.protogalaxy.phss.datasource.entity.core.personaldata.calender.CalenderEventEntity;
import org.springframework.data.repository.CrudRepository;

public interface CalenderEventRepository extends CrudRepository<CalenderEventEntity, Integer> {
}
