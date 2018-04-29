package me.protogalaxy.datasource.entity.repository.personaldata.calender;

import me.protogalaxy.datasource.entity.core.personaldata.calender.CalenderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface CalenderRepository extends Repository<CalenderEntity, Integer>, CrudRepository<CalenderEntity, Integer> {
}
