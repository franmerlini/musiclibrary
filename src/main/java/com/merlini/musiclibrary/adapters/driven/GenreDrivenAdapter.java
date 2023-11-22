package com.merlini.musiclibrary.adapters.driven;

import static java.util.stream.StreamSupport.stream;

import com.merlini.musiclibrary.adapters.driven.entities.GenreEntity;
import com.merlini.musiclibrary.adapters.driven.exceptions.EntityNotFoundException;
import com.merlini.musiclibrary.adapters.driven.mappers.GenrePersistenceMapper;
import com.merlini.musiclibrary.adapters.driven.repositories.GenreRepository;
import com.merlini.musiclibrary.domain.models.Genre;
import com.merlini.musiclibrary.ports.driven.GenreDrivenPort;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GenreDrivenAdapter implements GenreDrivenPort {
  private final GenreRepository genreRepository;
  private final GenrePersistenceMapper genrePersistenceMapper;

  @Override
  public Genre createGenre(Genre genre) {
    try {
      GenreEntity genreEntity = genrePersistenceMapper.genreToGenreEntity(genre);
      GenreEntity savedGenreEntity = genreRepository.save(genreEntity);

      return genrePersistenceMapper.genreEntityToGenre(savedGenreEntity);
    } catch (Exception e) {
      throw new RuntimeException("Error while creating genre.");
    }
  }

  @Override
  public Genre getGenreById(Integer id) {
    try {
      Optional<GenreEntity> genreEntity = genreRepository.findById(id);

      if (genreEntity.isEmpty()) {
        throw new EntityNotFoundException("Genre not found.");
      }

      return genrePersistenceMapper.genreEntityToGenre(genreEntity.get());
    } catch (EntityNotFoundException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error while getting genre.");
    }
  }

  @Override
  public Genre updateGenre(Integer id, Genre genre) {
    try {
      Optional<GenreEntity> genreEntity = genreRepository.findById(id);

      if (genreEntity.isEmpty()) {
        throw new EntityNotFoundException("Genre not found.");
      }

      genreEntity.get().setName(genre.getName());

      GenreEntity updatedGenreEntity = genreRepository.save(genreEntity.get());

      return genrePersistenceMapper.genreEntityToGenre(updatedGenreEntity);
    } catch (EntityNotFoundException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error while updating genre.");
    }
  }

  @Override
  public void deleteGenre(Integer id) {
    try {
      boolean exists = genreRepository.existsById(id);

      if (!exists) {
        throw new EntityNotFoundException("Genre not found.");
      }

      genreRepository.deleteById(id);
    } catch (EntityNotFoundException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error while deleting genre.");
    }
  }

  @Override
  public List<Genre> getAllGenres() {
    try {
      Iterable<GenreEntity> genreEntities = genreRepository.findAll();

      return stream(genreEntities.spliterator(), false)
          .map(genrePersistenceMapper::genreEntityToGenre)
          .toList();
    } catch (Exception e) {
      throw new RuntimeException("Error while getting all genres.");
    }
  }
}
