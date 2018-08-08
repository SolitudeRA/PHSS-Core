package org.protogalaxy.phss.datasource.repository.jpa.personaldata.calender;

import org.protogalaxy.phss.datasource.entity.personaldata.calender.CalenderEventEntity;
import org.springframework.data.repository.CrudRepository;

public interface CalenderEventRepository extends CrudRepository<CalenderEventEntity, Integer> {
}
