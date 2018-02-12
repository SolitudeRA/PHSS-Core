package datasource.entity.settingsCore.securitylayer;

import javax.persistence.*;

/**
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 * TODO: 2018/1/26 Entity Design
 */

@Entity
@Table(name = "settings_access_level")
public class SettingAccessLevelLayer {
    @Id
    private Integer id;

    @Column(name = "settings_owner_id")
    private Integer seId;

    @Column(name = "name")
    private String name;

    @Column(name = "encrypted")
    private Integer encrypted;

    @Column(name = "keyneeded")
    private Integer keyNeeded;

    public SettingAccessLevelLayer() {
    }


}
