package com.merlini.musiclibrary.adapters.driven.mappers;

import com.merlini.musiclibrary.adapters.driven.entities.AlbumEntity;
import com.merlini.musiclibrary.domain.models.Album;
import org.mapstruct.Mapper;

@Mapper
public interface AlbumPersistenceMapper {
  AlbumEntity albumToAlbumEntity(Album album);

  Album albumEntityToAlbum(AlbumEntity albumEntity);
}
