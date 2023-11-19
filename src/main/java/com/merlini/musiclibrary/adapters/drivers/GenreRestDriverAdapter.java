package com.merlini.musiclibrary.adapters.drivers;

import com.merlini.musiclibrary.adapters.drivers.mappers.GenreRestMapper;
import com.merlini.musiclibrary.adapters.drivers.requests.GenreRequest;
import com.merlini.musiclibrary.domain.models.Genre;
import com.merlini.musiclibrary.ports.drivers.GenreDriverPort;
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
@RequestMapping("/api/genres")
public class GenreRestDriverAdapter {
  private final GenreDriverPort genreDriverPort;
  private final GenreRestMapper genreRestMapper;

  @PostMapping
  public ResponseEntity<?> createGenre(@RequestBody @Valid GenreRequest genreRequest) {
    Genre genre = this.genreRestMapper.toGenre(genreRequest);
    Genre createdGenre = this.genreDriverPort.createGenre(genre);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(this.genreRestMapper.toGenreResponse(createdGenre));
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getGenreById(@PathVariable int id) {
    Genre genre = this.genreDriverPort.getGenreById(id);
    return ResponseEntity.ok(this.genreRestMapper.toGenreResponse(genre));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<?> updateGenre(@PathVariable int id,
                                       @RequestBody GenreRequest genreRequest) {
    Genre genre = this.genreRestMapper.toGenre(genreRequest);
    Genre updatedGenre = this.genreDriverPort.updateGenre(id, genre);
    return ResponseEntity.ok(this.genreRestMapper.toGenreResponse(updatedGenre));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteGenre(@PathVariable int id) {
    this.genreDriverPort.deleteGenre(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping
  public ResponseEntity<?> getAllGenres() {
    List<Genre> genres = this.genreDriverPort.getAllGenres();
    return ResponseEntity.ok(genres.stream().map(genreRestMapper::toGenreResponse).toList());
  }
}
