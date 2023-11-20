package com.merlini.musiclibrary.adapters.drivers.requests;

import jakarta.validation.Valid;
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
  @NotNull(message = "Album title is mandatory.")
  @NotBlank(message = "Album title is mandatory.")
  private String title;

  @Valid
  @NotNull(message = "Artist is mandatory.")
  private ArtistRequest artist;
}
