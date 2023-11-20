package com.merlini.musiclibrary.adapters.driven.mappers;

import com.merlini.musiclibrary.adapters.driven.entities.MediaTypeEntity;
import com.merlini.musiclibrary.domain.models.MediaType;
import org.mapstruct.Mapper;

@Mapper
public interface MediaTypePersistenceMapper {
  MediaTypeEntity mediaTypeToMediaTypeEntity(MediaType mediaType);

  MediaType mediaTypeEntityToMediaType(MediaTypeEntity mediaTypeEntity);
}
