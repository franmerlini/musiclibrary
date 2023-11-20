package com.merlini.musiclibrary.adapters.drivers;

import com.merlini.musiclibrary.adapters.drivers.mappers.TrackRestMapper;
import com.merlini.musiclibrary.adapters.drivers.requests.TrackRequest;
import com.merlini.musiclibrary.adapters.drivers.responses.TrackResponse;
import com.merlini.musiclibrary.domain.models.Track;
import com.merlini.musiclibrary.ports.drivers.TrackDriverPort;
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
@RequestMapping("/api/tracks")
public class TrackRestDriverAdapter {
  private final TrackDriverPort trackDriverPort;
  private final TrackRestMapper trackRestMapper;

  @PostMapping
  public ResponseEntity<TrackResponse> createTrack(@RequestBody @Valid TrackRequest trackRequest) {
    Track track = trackRestMapper.toTrack(trackRequest);
    Track createdTrack = trackDriverPort.createTrack(track);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(trackRestMapper.toTrackResponse(createdTrack));
  }

  @GetMapping("/{id}")
  public ResponseEntity<TrackResponse> getTrackById(@PathVariable int id) {
    Track track = trackDriverPort.getTrackById(id);
    return ResponseEntity.ok(trackRestMapper.toTrackResponse(track));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<TrackResponse> updateTrack(@PathVariable int id,
                                                   @RequestBody @Valid TrackRequest trackRequest) {
    Track track = trackRestMapper.toTrack(trackRequest);
    Track updatedTrack = trackDriverPort.updateTrack(id, track);
    return ResponseEntity.ok(trackRestMapper.toTrackResponse(updatedTrack));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<TrackResponse> deleteTrack(@PathVariable int id) {
    trackDriverPort.deleteTrack(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping
  public ResponseEntity<List<TrackResponse>> getAllTracks() {
    List<Track> tracks = trackDriverPort.getAllTracks();
    return ResponseEntity.ok(tracks.stream().map(trackRestMapper::toTrackResponse).toList());
  }
}
