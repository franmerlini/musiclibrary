package com.merlini.musiclibrary.domain.services;

import com.merlini.musiclibrary.domain.models.Genre;
import com.merlini.musiclibrary.ports.driven.GenreDrivenPort;
import com.merlini.musiclibrary.ports.drivers.GenreDriverPort;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GenreService implements GenreDriverPort {
  private final GenreDrivenPort genreDrivenPort;

  @Override
  public Genre createGenre(Genre genre) {
    return genreDrivenPort.createGenre(genre);
  }

  @Override
  public Genre getGenreById(Integer id) {
    return genreDrivenPort.getGenreById(id);
  }

  @Override
  public Genre updateGenre(Integer id, Genre genre) {
    return genreDrivenPort.updateGenre(id, genre);
  }

  @Override
  public boolean deleteGenre(Integer id) {
    return genreDrivenPort.deleteGenre(id);
  }

  @Override
  public List<Genre> getAllGenres() {
    return genreDrivenPort.getAllGenres();
  }
}
