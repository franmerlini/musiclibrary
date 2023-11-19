package com.merlini.musiclibrary.adapters.driven.mappers;

import com.merlini.musiclibrary.adapters.driven.entities.GenreEntity;
import com.merlini.musiclibrary.domain.models.Genre;
import org.mapstruct.Mapper;

@Mapper
public interface GenrePersistenceMapper {
  GenreEntity genreToGenreEntity(Genre genre);

  Genre genreEntityToGenre(GenreEntity genreEntity);
}
