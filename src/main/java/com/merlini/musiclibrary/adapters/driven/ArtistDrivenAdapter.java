package com.merlini.musiclibrary.adapters.driven;

import static java.util.stream.StreamSupport.stream;

import com.merlini.musiclibrary.adapters.driven.entities.ArtistEntity;
import com.merlini.musiclibrary.adapters.driven.exceptions.EntityNotFoundException;
import com.merlini.musiclibrary.adapters.driven.mappers.ArtistPersistenceMapper;
import com.merlini.musiclibrary.adapters.driven.repositories.ArtistRepository;
import com.merlini.musiclibrary.domain.models.Artist;
import com.merlini.musiclibrary.ports.driven.ArtistDrivenPort;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ArtistDrivenAdapter implements ArtistDrivenPort {
  private final ArtistRepository artistRepository;
  private final ArtistPersistenceMapper artistPersistenceMapper;

  @Override
  public Artist createArtist(Artist artist) {
    try {
      ArtistEntity artistEntity = artistPersistenceMapper.artistToArtistEntity(artist);
      ArtistEntity savedArtistEntity = artistRepository.save(artistEntity);

      return artistPersistenceMapper.artistEntityToArtist(savedArtistEntity);
    } catch (Exception e) {
      throw new RuntimeException("Error while creating artist.");
    }
  }

  @Override
  public Artist getArtistById(Integer id) {
    try {
      Optional<ArtistEntity> artistEntity = artistRepository.findById(id);

      if (artistEntity.isEmpty()) {
        throw new EntityNotFoundException("Artist not found.");
      }

      return artistPersistenceMapper.artistEntityToArtist(artistEntity.get());
    } catch (EntityNotFoundException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error while getting artist.");
    }
  }

  @Override
  public Artist updateArtist(Integer id, Artist artist) {
    try {
      Optional<ArtistEntity> artistEntity = artistRepository.findById(id);

      if (artistEntity.isEmpty()) {
        throw new EntityNotFoundException("Artist not found.");
      }

      ArtistEntity toUpdateArtistEntity = artistPersistenceMapper.artistToArtistEntity(artist);
      ArtistEntity updatedArtistEntity = artistRepository.save(toUpdateArtistEntity);

      return artistPersistenceMapper.artistEntityToArtist(updatedArtistEntity);
    } catch (EntityNotFoundException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error while updating artist.");
    }
  }

  @Override
  public void deleteArtist(Integer id) {
    try {
      boolean exists = artistRepository.existsById(id);

      if (!exists) {
        throw new EntityNotFoundException("Artist not found.");
      }

      artistRepository.deleteById(id);
    } catch (EntityNotFoundException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error while deleting artist.");
    }
  }

  @Override
  public List<Artist> getAllArtists() {
    try {
      Iterable<ArtistEntity> artistEntities = artistRepository.findAll();

      return stream(artistEntities.spliterator(), false)
          .map(artistPersistenceMapper::artistEntityToArtist)
          .toList();
    } catch (Exception e) {
      throw new RuntimeException("Error while getting all artists.");
    }
  }
}
