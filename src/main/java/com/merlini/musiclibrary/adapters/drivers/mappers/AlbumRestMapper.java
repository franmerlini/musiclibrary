package com.merlini.musiclibrary.adapters.drivers.mappers;

import com.merlini.musiclibrary.adapters.drivers.requests.AlbumRequest;
import com.merlini.musiclibrary.adapters.drivers.responses.AlbumResponse;
import com.merlini.musiclibrary.domain.models.Album;
import org.mapstruct.Mapper;

@Mapper
public interface AlbumRestMapper {
  Album toAlbum(AlbumRequest albumRequest);

  AlbumResponse toAlbumResponse(Album album);
}
