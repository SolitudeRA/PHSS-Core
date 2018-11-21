package org.protogalaxy.phss.datasource.resource.assembler.filesystem.music;

import org.protogalaxy.phss.controller.filesystem.MusicController;
import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicAlbumEntity;
import org.protogalaxy.phss.datasource.resource.main.entity.filesystem.music.MusicAlbumResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import java.util.List;

public class MusicAlbumResourceAssembler extends ResourceAssemblerSupport<MusicAlbumEntity, MusicAlbumResource> {

    public MusicAlbumResourceAssembler() {
        super(MusicController.class, MusicAlbumResource.class);
    }

    @Override
    public MusicAlbumResource toResource(MusicAlbumEntity musicAlbumEntity) {
        return new MusicAlbumResource(musicAlbumEntity);
    }


    @Override
    public List<MusicAlbumResource> toResources(Iterable<? extends MusicAlbumEntity> musicAlbumEntities) {
        return super.toResources(musicAlbumEntities);
    }
}
