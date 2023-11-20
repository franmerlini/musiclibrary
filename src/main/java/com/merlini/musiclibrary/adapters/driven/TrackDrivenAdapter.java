package com.merlini.musiclibrary.adapters.driven;

import static java.util.stream.StreamSupport.stream;

import com.merlini.musiclibrary.adapters.driven.entities.TrackEntity;
import com.merlini.musiclibrary.adapters.driven.exceptions.EntityNotFoundException;
import com.merlini.musiclibrary.adapters.driven.mappers.TrackPersistenceMapper;
import com.merlini.musiclibrary.adapters.driven.repositories.AlbumRepository;
import com.merlini.musiclibrary.adapters.driven.repositories.GenreRepository;
import com.merlini.musiclibrary.adapters.driven.repositories.MediaTypeRepository;
import com.merlini.musiclibrary.adapters.driven.repositories.TrackRepository;
import com.merlini.musiclibrary.domain.models.Track;
import com.merlini.musiclibrary.ports.driven.TrackDrivenPort;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TrackDrivenAdapter implements TrackDrivenPort {
  private final TrackRepository trackRepository;
  private final TrackPersistenceMapper trackPersistenceMapper;
  private final GenreRepository genreRepository;
  private final MediaTypeRepository mediaTypeRepository;
  private final AlbumRepository albumRepository;

  @Override
  public Track createTrack(Track track) {
    try {
      boolean existsGenre = genreRepository.existsById(track.getGenre().getId());

      if (!existsGenre) {
        throw new EntityNotFoundException("Genre not found.");
      }

      boolean existsMediaType = mediaTypeRepository.existsById(track.getMediaType().getId());

      if (!existsMediaType) {
        throw new EntityNotFoundException("Media type not found.");
      }

      boolean existsAlbum = albumRepository.existsById(track.getAlbum().getId());

      if (!existsAlbum) {
        throw new EntityNotFoundException("Album not found.");
      }

      TrackEntity trackEntity = trackPersistenceMapper.trackToTrackEntity(track);
      TrackEntity savedTrackEntity = this.trackRepository.save(trackEntity);

      return trackPersistenceMapper.trackEntityToTrack(savedTrackEntity);
    } catch (EntityNotFoundException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error while creating track.");
    }
  }

  @Override
  public Track getTrackById(Integer id) {
    try {
      Optional<TrackEntity> trackEntity = this.trackRepository.findById(id);

      if (trackEntity.isEmpty()) {
        throw new EntityNotFoundException("Track not found.");
      }

      return trackPersistenceMapper.trackEntityToTrack(trackEntity.get());
    } catch (EntityNotFoundException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error while getting track.");
    }
  }

  @Override
  public Track updateTrack(Integer id, Track track) {
    try {
      Optional<TrackEntity> trackEntity = this.trackRepository.findById(id);

      if (trackEntity.isEmpty()) {
        throw new EntityNotFoundException("Track not found.");
      }

      TrackEntity toUpdateTrackEntity = trackPersistenceMapper.trackToTrackEntity(track);
      TrackEntity updatedTrackEntity = this.trackRepository.save(toUpdateTrackEntity);

      return trackPersistenceMapper.trackEntityToTrack(updatedTrackEntity);
    } catch (EntityNotFoundException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error while updating track.");
    }
  }

  @Override
  public void deleteTrack(Integer id) {
    try {
      boolean exists = this.trackRepository.existsById(id);

      if (!exists) {
        throw new EntityNotFoundException("Track not found.");
      }

      this.trackRepository.deleteById(id);
    } catch (EntityNotFoundException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error while deleting track.");
    }
  }

  @Override
  public List<Track> getAllTracks() {
    try {
      Iterable<TrackEntity> trackEntities = this.trackRepository.findAll();

      return stream(trackEntities.spliterator(), false)
          .map(trackPersistenceMapper::trackEntityToTrack)
          .toList();
    } catch (Exception e) {
      throw new RuntimeException("Error while getting all tracks.");
    }
  }
}
