package com.merlini.musiclibrary.ports.driven;

import com.merlini.musiclibrary.domain.models.MediaType;
import java.util.List;

public interface MediaTypeDrivenPort {
  MediaType createMediaType(MediaType mediaType);

  MediaType getMediaTypeById(Integer id);

  MediaType updateMediaType(Integer id, MediaType mediaType);

  void deleteMediaType(Integer id);

  List<MediaType> getAllMediaTypes();
}
