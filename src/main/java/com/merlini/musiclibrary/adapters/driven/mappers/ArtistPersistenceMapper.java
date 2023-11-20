package com.merlini.musiclibrary.adapters.driven.mappers;

import com.merlini.musiclibrary.adapters.driven.entities.ArtistEntity;
import com.merlini.musiclibrary.domain.models.Artist;
import org.mapstruct.Mapper;

@Mapper
public interface ArtistPersistenceMapper {
  ArtistEntity artistToArtistEntity(Artist artist);

  Artist artistEntityToArtist(ArtistEntity artistEntity);
}
