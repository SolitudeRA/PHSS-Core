package org.protogalaxy.phss.datasource.repository.jpa.setting;

import org.protogalaxy.phss.datasource.entity.setting.SettingsMainEntity;
import org.springframework.data.repository.CrudRepository;

public interface SettingMainRepository extends CrudRepository<SettingsMainEntity, Integer> {
}
