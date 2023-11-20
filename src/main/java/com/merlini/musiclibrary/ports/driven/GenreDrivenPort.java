package com.merlini.musiclibrary.ports.driven;

import com.merlini.musiclibrary.domain.models.Genre;
import java.util.List;

public interface GenreDrivenPort {
  Genre createGenre(Genre genre);

  Genre getGenreById(Integer id);

  Genre updateGenre(Integer id, Genre genre);

  void deleteGenre(Integer id);

  List<Genre> getAllGenres();
}
