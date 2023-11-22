package com.merlini.musiclibrary.adapters.drivers;

import com.merlini.musiclibrary.adapters.drivers.mappers.PlaylistRestMapper;
import com.merlini.musiclibrary.adapters.drivers.requests.PlaylistRequest;
import com.merlini.musiclibrary.adapters.drivers.responses.PlaylistResponse;
import com.merlini.musiclibrary.domain.models.Playlist;
import com.merlini.musiclibrary.ports.drivers.PlaylistDriverPort;
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
@RequestMapping("/api/playlists")
public class PlaylistRestDriverAdapter {
  private final PlaylistDriverPort playlistDriverPort;
  private final PlaylistRestMapper playlistRestMapper;

  @PostMapping
  public ResponseEntity<PlaylistResponse> createPlaylist(
      @RequestBody @Valid PlaylistRequest playlistRequest) {
    Playlist playlist = playlistRestMapper.toPlaylist(playlistRequest);
    Playlist createdPlaylist = playlistDriverPort.createPlaylist(playlist);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(playlistRestMapper.toPlaylistResponse(createdPlaylist));
  }

  @GetMapping("/{id}")
  public ResponseEntity<PlaylistResponse> getPlaylistById(@PathVariable int id) {
    Playlist playlist = playlistDriverPort.getPlaylistById(id);
    return ResponseEntity.ok(playlistRestMapper.toPlaylistResponse(playlist));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<PlaylistResponse> updatePlaylist(@PathVariable int id,
                                                         @RequestBody
                                                         @Valid PlaylistRequest playlistRequest) {
    Playlist playlist = playlistRestMapper.toPlaylist(playlistRequest);
    Playlist updatedPlaylist = playlistDriverPort.updatePlaylist(id, playlist);
    return ResponseEntity.ok(playlistRestMapper.toPlaylistResponse(updatedPlaylist));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<PlaylistResponse> deletePlaylist(@PathVariable int id) {
    playlistDriverPort.deletePlaylist(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping
  public ResponseEntity<List<PlaylistResponse>> getAllPlaylists() {
    List<Playlist> playlists = playlistDriverPort.getAllPlaylists();
    return ResponseEntity.ok(
        playlists.stream().map(playlistRestMapper::toPlaylistResponse).toList());
  }
}
