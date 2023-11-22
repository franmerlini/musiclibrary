package com.merlini.musiclibrary.adapters.driven;

import static java.util.stream.StreamSupport.stream;

import com.merlini.musiclibrary.adapters.driven.entities.PlaylistEntity;
import com.merlini.musiclibrary.adapters.driven.exceptions.EntityNotFoundException;
import com.merlini.musiclibrary.adapters.driven.mappers.PlaylistPersistenceMapper;
import com.merlini.musiclibrary.adapters.driven.repositories.PlaylistRepository;
import com.merlini.musiclibrary.domain.models.Playlist;
import com.merlini.musiclibrary.ports.driven.PlaylistDrivenPort;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlaylistDrivenAdapter implements PlaylistDrivenPort {
  private final PlaylistRepository playlistRepository;
  private final PlaylistPersistenceMapper playlistPersistenceMapper;

  @Override
  public Playlist createPlaylist(Playlist playlist) {
    try {
      PlaylistEntity playlistEntity = playlistPersistenceMapper.playlistToPlaylistEntity(playlist);
      PlaylistEntity savedPlaylistEntity = this.playlistRepository.save(playlistEntity);

      return playlistPersistenceMapper.playlistEntityToPlaylist(savedPlaylistEntity);
    } catch (Exception e) {
      throw new RuntimeException("Error while creating playlist.");
    }
  }

  @Override
  public Playlist getPlaylistById(Integer id) {
    try {
      Optional<PlaylistEntity> playlistEntity = this.playlistRepository.findById(id);

      if (playlistEntity.isEmpty()) {
        throw new EntityNotFoundException("Playlist not found.");
      }

      return playlistPersistenceMapper.playlistEntityToPlaylist(playlistEntity.get());
    } catch (EntityNotFoundException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error while getting playlist.");
    }
  }

  @Override
  public Playlist updatePlaylist(Integer id, Playlist playlist) {
    try {
      Optional<PlaylistEntity> playlistEntity = this.playlistRepository.findById(id);

      if (playlistEntity.isEmpty()) {
        throw new EntityNotFoundException("Playlist not found.");
      }

      PlaylistEntity toUpdatePlaylistEntity =
          playlistPersistenceMapper.playlistToPlaylistEntity(playlist);
      PlaylistEntity updatedPlaylistEntity = this.playlistRepository.save(toUpdatePlaylistEntity);

      return playlistPersistenceMapper.playlistEntityToPlaylist(updatedPlaylistEntity);
    } catch (EntityNotFoundException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error while updating playlist.");
    }
  }

  @Override
  public void deletePlaylist(Integer id) {
    try {
      boolean exists = this.playlistRepository.existsById(id);

      if (!exists) {
        throw new EntityNotFoundException("Playlist not found.");
      }

      this.playlistRepository.deleteById(id);
    } catch (EntityNotFoundException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error while deleting playlist.");
    }
  }

  @Override
  public List<Playlist> getAllPlaylists() {
    try {
      Iterable<PlaylistEntity> playlistEntities = this.playlistRepository.findAll();

      return stream(playlistEntities.spliterator(), false)
          .map(playlistPersistenceMapper::playlistEntityToPlaylist)
          .toList();
    } catch (Exception e) {
      throw new RuntimeException("Error while getting all playlists.");
    }
  }
}
