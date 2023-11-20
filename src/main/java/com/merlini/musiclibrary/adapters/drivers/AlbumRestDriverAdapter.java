package com.merlini.musiclibrary.adapters.drivers;

import com.merlini.musiclibrary.adapters.drivers.mappers.AlbumRestMapper;
import com.merlini.musiclibrary.adapters.drivers.requests.AlbumRequest;
import com.merlini.musiclibrary.adapters.drivers.responses.AlbumResponse;
import com.merlini.musiclibrary.domain.models.Album;
import com.merlini.musiclibrary.ports.drivers.AlbumDriverPort;
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
@RequestMapping("/api/albums")
public class AlbumRestDriverAdapter {
  private final AlbumDriverPort albumDriverPort;
  private final AlbumRestMapper albumRestMapper;

  @PostMapping
  public ResponseEntity<AlbumResponse> createAlbum(@RequestBody @Valid AlbumRequest albumRequest) {
    Album album = this.albumRestMapper.toAlbum(albumRequest);
    Album createdAlbum = this.albumDriverPort.createAlbum(album);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(this.albumRestMapper.toAlbumResponse(createdAlbum));
  }

  @GetMapping("/{id}")
  public ResponseEntity<AlbumResponse> getAlbumById(@PathVariable int id) {
    Album album = this.albumDriverPort.getAlbumById(id);
    return ResponseEntity.ok(this.albumRestMapper.toAlbumResponse(album));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<AlbumResponse> updateAlbum(@PathVariable int id,
                                                   @RequestBody @Valid AlbumRequest albumRequest) {
    Album album = this.albumRestMapper.toAlbum(albumRequest);
    Album updatedAlbum = this.albumDriverPort.updateAlbum(id, album);
    return ResponseEntity.ok(this.albumRestMapper.toAlbumResponse(updatedAlbum));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<AlbumResponse> deleteAlbum(@PathVariable int id) {
    this.albumDriverPort.deleteAlbum(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping
  public ResponseEntity<List<AlbumResponse>> getAllAlbums() {
    List<Album> albums = this.albumDriverPort.getAllAlbums();
    return ResponseEntity.ok(albums.stream().map(albumRestMapper::toAlbumResponse).toList());
  }
}
