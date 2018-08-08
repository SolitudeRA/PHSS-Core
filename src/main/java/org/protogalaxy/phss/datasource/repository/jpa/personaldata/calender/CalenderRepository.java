package org.protogalaxy.phss.datasource.repository.jpa.personaldata.calender;

import org.protogalaxy.phss.datasource.entity.personaldata.calender.CalenderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CalenderRepository extends JpaRepository<CalenderEntity, Integer>, CrudRepository<CalenderEntity, Integer> {
}
