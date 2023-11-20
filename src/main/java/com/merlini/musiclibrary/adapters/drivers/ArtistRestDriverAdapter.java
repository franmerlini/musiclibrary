package com.merlini.musiclibrary.adapters.drivers;

import com.merlini.musiclibrary.adapters.drivers.mappers.ArtistRestMapper;
import com.merlini.musiclibrary.adapters.drivers.requests.ArtistRequest;
import com.merlini.musiclibrary.adapters.drivers.responses.ArtistResponse;
import com.merlini.musiclibrary.domain.models.Artist;
import com.merlini.musiclibrary.ports.drivers.ArtistDriverPort;
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
@RequestMapping("/api/artists")
public class ArtistRestDriverAdapter {
  private final ArtistDriverPort artistDriverPort;
  private final ArtistRestMapper artistRestMapper;

  @PostMapping
  public ResponseEntity<ArtistResponse> createArtist(
      @RequestBody @Valid ArtistRequest artistRequest) {
    Artist artist = this.artistRestMapper.toArtist(artistRequest);
    Artist createdArtist = this.artistDriverPort.createArtist(artist);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(this.artistRestMapper.toArtistResponse(createdArtist));
  }

  @GetMapping("/{id}")
  public ResponseEntity<ArtistResponse> getArtistById(@PathVariable int id) {
    Artist artist = this.artistDriverPort.getArtistById(id);
    return ResponseEntity.ok(this.artistRestMapper.toArtistResponse(artist));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<ArtistResponse> updateArtist(@PathVariable int id,
                                                     @RequestBody
                                                     @Valid ArtistRequest artistRequest) {
    Artist artist = this.artistRestMapper.toArtist(artistRequest);
    Artist updatedArtist = this.artistDriverPort.updateArtist(id, artist);
    return ResponseEntity.ok(this.artistRestMapper.toArtistResponse(updatedArtist));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ArtistResponse> deleteArtist(@PathVariable int id) {
    this.artistDriverPort.deleteArtist(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping
  public ResponseEntity<List<ArtistResponse>> getAllArtists() {
    List<Artist> artists = this.artistDriverPort.getAllArtists();
    return ResponseEntity.ok(artists.stream().map(artistRestMapper::toArtistResponse).toList());
  }
}
