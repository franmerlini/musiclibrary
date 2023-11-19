package com.merlini.musiclibrary.adapters.drivers.mappers;

import com.merlini.musiclibrary.adapters.drivers.requests.GenreRequest;
import com.merlini.musiclibrary.adapters.drivers.responses.GenreResponse;
import com.merlini.musiclibrary.domain.models.Genre;
import org.mapstruct.Mapper;

@Mapper
public interface GenreRestMapper {
  Genre toGenre(GenreRequest genreRequest);

  GenreResponse toGenreResponse(Genre genre);
}
