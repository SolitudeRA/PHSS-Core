package org.protogalaxy.phss.datasource.resource.assembler.filesystem.music;

import org.protogalaxy.phss.controller.filesystem.MusicController;
import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicTrackEntity;
import org.protogalaxy.phss.datasource.resource.main.entity.filesystem.music.MusicTrackResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import java.util.List;

public class MusicTrackResourceAssembler extends ResourceAssemblerSupport<MusicTrackEntity, MusicTrackResource> {
    public MusicTrackResourceAssembler() {
        super(MusicController.class, MusicTrackResource.class);
    }

    @Override
    public MusicTrackResource toResource(MusicTrackEntity musicTrackEntity) {
        return new MusicTrackResource(musicTrackEntity);
    }


    @Override
    public List<MusicTrackResource> toResources(Iterable<? extends MusicTrackEntity> musicTrackEntities) {
        return super.toResources(musicTrackEntities);
    }
}
