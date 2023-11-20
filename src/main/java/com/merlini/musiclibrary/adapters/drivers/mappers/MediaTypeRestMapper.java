package com.merlini.musiclibrary.adapters.drivers.mappers;

import com.merlini.musiclibrary.adapters.drivers.requests.MediaTypeRequest;
import com.merlini.musiclibrary.adapters.drivers.responses.MediaTypeResponse;
import com.merlini.musiclibrary.domain.models.MediaType;
import org.mapstruct.Mapper;

@Mapper
public interface MediaTypeRestMapper {
  MediaType toMediaType(MediaTypeRequest mediaTypeRequest);

  MediaTypeResponse toMediaTypeResponse(MediaType mediaType);
}
