package com.merlini.musiclibrary.adapters.drivers.requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlbumRequest {
  @NotNull(message = "Album ID is required.", groups = TrackRequest.class)
  @Digits(integer = 10, fraction = 0, message = "Album ID must be an integer.", groups = TrackRequest.class)
  private Integer id;

  @NotNull(message = "Album title is required.", groups = AlbumRequest.class)
  @NotBlank(message = "Album title is required.", groups = AlbumRequest.class)
  private String title;

  @Valid
  @NotNull(message = "Artist is required.", groups = AlbumRequest.class)
  private ArtistRequest artist;
}
