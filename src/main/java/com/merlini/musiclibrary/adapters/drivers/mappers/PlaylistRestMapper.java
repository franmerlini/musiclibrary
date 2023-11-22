package com.merlini.musiclibrary.adapters.drivers.mappers;

import com.merlini.musiclibrary.adapters.drivers.requests.PlaylistRequest;
import com.merlini.musiclibrary.adapters.drivers.responses.PlaylistResponse;
import com.merlini.musiclibrary.domain.models.Playlist;
import org.mapstruct.Mapper;

@Mapper
public interface PlaylistRestMapper {
  Playlist toPlaylist(PlaylistRequest playlistRequest);

  PlaylistResponse toPlaylistResponse(Playlist playlist);
}
