package com.merlini.musiclibrary.adapters.driven.mappers;

import com.merlini.musiclibrary.adapters.driven.entities.PlaylistEntity;
import com.merlini.musiclibrary.domain.models.Playlist;
import org.mapstruct.Mapper;

@Mapper
public interface PlaylistPersistenceMapper {
  PlaylistEntity playlistToPlaylistEntity(Playlist playlist);

  Playlist playlistEntityToPlaylist(PlaylistEntity playlistEntity);
}
