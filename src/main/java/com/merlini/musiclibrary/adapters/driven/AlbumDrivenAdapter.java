package com.merlini.musiclibrary.adapters.driven;

import static java.util.stream.StreamSupport.stream;

import com.merlini.musiclibrary.adapters.driven.entities.AlbumEntity;
import com.merlini.musiclibrary.adapters.driven.entities.ArtistEntity;
import com.merlini.musiclibrary.adapters.driven.exceptions.EntityNotFoundException;
import com.merlini.musiclibrary.adapters.driven.mappers.AlbumPersistenceMapper;
import com.merlini.musiclibrary.adapters.driven.repositories.AlbumRepository;
import com.merlini.musiclibrary.adapters.driven.repositories.ArtistRepository;
import com.merlini.musiclibrary.domain.models.Album;
import com.merlini.musiclibrary.ports.driven.AlbumDrivenPort;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AlbumDrivenAdapter implements AlbumDrivenPort {
  private final AlbumRepository albumRepository;
  private final AlbumPersistenceMapper albumPersistenceMapper;
  private final ArtistRepository artistRepository;

  @Override
  public Album createAlbum(Album album) {
    try {
      boolean exists = artistRepository.existsById(album.getArtist().getId());

      if (!exists) {
        throw new EntityNotFoundException("Artist not found.");
      }

      AlbumEntity albumEntity = albumPersistenceMapper.albumToAlbumEntity(album);
      AlbumEntity savedAlbumEntity = albumRepository.save(albumEntity);

      return albumPersistenceMapper.albumEntityToAlbum(savedAlbumEntity);
    } catch (EntityNotFoundException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error while creating album.");
    }
  }

  @Override
  public Album getAlbumById(Integer id) {
    try {
      Optional<AlbumEntity> albumEntity = albumRepository.findById(id);

      if (albumEntity.isEmpty()) {
        throw new EntityNotFoundException("Album not found.");
      }

      return albumPersistenceMapper.albumEntityToAlbum(albumEntity.get());
    } catch (EntityNotFoundException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error while getting album.");
    }
  }

  @Override
  public Album updateAlbum(Integer id, Album album) {
    try {
      Optional<AlbumEntity> albumEntity = albumRepository.findById(id);

      if (albumEntity.isEmpty()) {
        throw new EntityNotFoundException("Album not found.");
      }

      Optional<ArtistEntity> artistEntity = artistRepository.findById(album.getArtist().getId());

      if (artistEntity.isEmpty()) {
        throw new EntityNotFoundException("Artist not found.");
      }

      albumEntity.get().setTitle(album.getTitle());
      albumEntity.get().setArtist(artistEntity.get());

      AlbumEntity updatedAlbumEntity = albumRepository.save(albumEntity.get());

      return albumPersistenceMapper.albumEntityToAlbum(updatedAlbumEntity);
    } catch (EntityNotFoundException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error while updating album.");
    }
  }

  @Override
  public void deleteAlbum(Integer id) {
    try {
      boolean exists = albumRepository.existsById(id);

      if (!exists) {
        throw new EntityNotFoundException("Album not found.");
      }

      albumRepository.deleteById(id);
    } catch (EntityNotFoundException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error while deleting album.");
    }
  }

  @Override
  public List<Album> getAllAlbums() {
    try {
      Iterable<AlbumEntity> albumEntities = albumRepository.findAll();

      return stream(albumEntities.spliterator(), false)
          .map(albumPersistenceMapper::albumEntityToAlbum)
          .toList();
    } catch (Exception e) {
      throw new RuntimeException("Error while getting all albums.");
    }
  }
}
