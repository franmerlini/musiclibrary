package com.merlini.musiclibrary.adapters.drivers.mappers;

import com.merlini.musiclibrary.adapters.drivers.requests.ArtistRequest;
import com.merlini.musiclibrary.adapters.drivers.responses.ArtistResponse;
import com.merlini.musiclibrary.domain.models.Artist;
import org.mapstruct.Mapper;

@Mapper
public interface ArtistRestMapper {
  Artist toArtist(ArtistRequest artistRequest);

  ArtistResponse toArtistResponse(Artist artist);
}
