package com.merlini.musiclibrary.domain.services;

import com.merlini.musiclibrary.domain.models.MediaType;
import com.merlini.musiclibrary.ports.driven.MediaTypeDrivenPort;
import com.merlini.musiclibrary.ports.drivers.MediaTypeDriverPort;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MediaTypeService implements MediaTypeDriverPort {
  private final MediaTypeDrivenPort mediaTypeDrivenPort;

  @Override
  public MediaType createMediaType(MediaType mediaType) {
    return mediaTypeDrivenPort.createMediaType(mediaType);
  }

  @Override
  public MediaType getMediaTypeById(Integer id) {
    return mediaTypeDrivenPort.getMediaTypeById(id);
  }

  @Override
  public MediaType updateMediaType(Integer id, MediaType mediaType) {
    return mediaTypeDrivenPort.updateMediaType(id, mediaType);
  }

  @Override
  public void deleteMediaType(Integer id) {
    mediaTypeDrivenPort.deleteMediaType(id);
  }

  @Override
  public List<MediaType> getAllMediaTypes() {
    return mediaTypeDrivenPort.getAllMediaTypes();
  }
}
