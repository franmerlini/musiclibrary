package com.merlini.musiclibrary.adapters.drivers;

import com.merlini.musiclibrary.adapters.drivers.mappers.MediaTypeRestMapper;
import com.merlini.musiclibrary.adapters.drivers.requests.MediaTypeRequest;
import com.merlini.musiclibrary.adapters.drivers.responses.MediaTypeResponse;
import com.merlini.musiclibrary.domain.models.MediaType;
import com.merlini.musiclibrary.ports.drivers.MediaTypeDriverPort;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mediaTypes")
public class MediaTypeRestDriverAdapter {
  private final MediaTypeDriverPort mediaTypeDriverPort;
  private final MediaTypeRestMapper mediaTypeRestMapper;

  @PostMapping
  public ResponseEntity<MediaTypeResponse> createMediaType(
      @RequestBody @Valid MediaTypeRequest mediaTypeRequest) {
    MediaType mediaType = mediaTypeRestMapper.toMediaType(mediaTypeRequest);
    MediaType createdMediaType = mediaTypeDriverPort.createMediaType(mediaType);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(mediaTypeRestMapper.toMediaTypeResponse(createdMediaType));
  }

  @GetMapping("/{id}")
  public ResponseEntity<MediaTypeResponse> getMediaTypeById(@PathVariable int id) {
    MediaType mediaType = mediaTypeDriverPort.getMediaTypeById(id);
    return ResponseEntity.ok(mediaTypeRestMapper.toMediaTypeResponse(mediaType));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<MediaTypeResponse> updateMediaType(@PathVariable int id,
                                                           @RequestBody
                                                           @Valid MediaTypeRequest mediaTypeRequest) {
    MediaType mediaType = mediaTypeRestMapper.toMediaType(mediaTypeRequest);
    MediaType updatedMediaType = mediaTypeDriverPort.updateMediaType(id, mediaType);
    return ResponseEntity.ok(mediaTypeRestMapper.toMediaTypeResponse(updatedMediaType));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<MediaTypeResponse> deleteMediaType(@PathVariable int id) {
    mediaTypeDriverPort.deleteMediaType(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping
  public ResponseEntity<List<MediaTypeResponse>> getAllMediaTypes() {
    List<MediaType> mediaTypes = mediaTypeDriverPort.getAllMediaTypes();
    return ResponseEntity.ok(
        mediaTypes.stream().map(mediaTypeRestMapper::toMediaTypeResponse).toList());
  }
}
