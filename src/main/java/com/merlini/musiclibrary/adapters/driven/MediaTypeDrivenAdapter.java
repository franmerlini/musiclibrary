package com.merlini.musiclibrary.adapters.driven;

import static java.util.stream.StreamSupport.stream;

import com.merlini.musiclibrary.adapters.driven.entities.MediaTypeEntity;
import com.merlini.musiclibrary.adapters.driven.exceptions.EntityNotFoundException;
import com.merlini.musiclibrary.adapters.driven.mappers.MediaTypePersistenceMapper;
import com.merlini.musiclibrary.adapters.driven.repositories.MediaTypeRepository;
import com.merlini.musiclibrary.domain.models.MediaType;
import com.merlini.musiclibrary.ports.driven.MediaTypeDrivenPort;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MediaTypeDrivenAdapter implements MediaTypeDrivenPort {
  private final MediaTypeRepository mediaTypeRepository;
  private final MediaTypePersistenceMapper mediaTypePersistenceMapper;

  @Override
  public MediaType createMediaType(MediaType mediaType) {
    try {
      MediaTypeEntity mediaTypeEntity =
          mediaTypePersistenceMapper.mediaTypeToMediaTypeEntity(mediaType);
      MediaTypeEntity savedMediaTypeEntity = this.mediaTypeRepository.save(mediaTypeEntity);

      return mediaTypePersistenceMapper.mediaTypeEntityToMediaType(savedMediaTypeEntity);
    } catch (Exception e) {
      throw new RuntimeException("Error while creating media type.");
    }
  }

  @Override
  public MediaType getMediaTypeById(Integer id) {
    try {
      Optional<MediaTypeEntity> mediaTypeEntity = this.mediaTypeRepository.findById(id);

      if (mediaTypeEntity.isEmpty()) {
        throw new EntityNotFoundException("MediaType not found.");
      }

      return mediaTypePersistenceMapper.mediaTypeEntityToMediaType(mediaTypeEntity.get());
    } catch (EntityNotFoundException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error while getting media type.");
    }
  }

  @Override
  public MediaType updateMediaType(Integer id, MediaType mediaType) {
    try {
      Optional<MediaTypeEntity> mediaTypeEntity = this.mediaTypeRepository.findById(id);

      if (mediaTypeEntity.isEmpty()) {
        throw new EntityNotFoundException("Media type not found.");
      }

      MediaTypeEntity toUpdateMediaTypeEntity =
          mediaTypePersistenceMapper.mediaTypeToMediaTypeEntity(mediaType);
      MediaTypeEntity updatedMediaTypeEntity =
          this.mediaTypeRepository.save(toUpdateMediaTypeEntity);

      return mediaTypePersistenceMapper.mediaTypeEntityToMediaType(updatedMediaTypeEntity);
    } catch (EntityNotFoundException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error while updating media type.");
    }
  }

  @Override
  public void deleteMediaType(Integer id) {
    try {
      boolean exists = this.mediaTypeRepository.existsById(id);

      if (!exists) {
        throw new EntityNotFoundException("Media type not found.");
      }

      this.mediaTypeRepository.deleteById(id);
    } catch (EntityNotFoundException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error while deleting media type.");
    }
  }

  @Override
  public List<MediaType> getAllMediaTypes() {
    try {
      Iterable<MediaTypeEntity> mediaTypeEntities = this.mediaTypeRepository.findAll();

      return stream(mediaTypeEntities.spliterator(), false)
          .map(mediaTypePersistenceMapper::mediaTypeEntityToMediaType)
          .toList();
    } catch (Exception e) {
      throw new RuntimeException("Error while getting all media types.");
    }
  }
}
