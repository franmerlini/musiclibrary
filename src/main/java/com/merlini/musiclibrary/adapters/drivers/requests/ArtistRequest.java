package com.merlini.musiclibrary.adapters.drivers.requests;

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
public class ArtistRequest {
  @NotNull(message = "Artist ID is required.", groups = AlbumRequest.class)
  @Digits(integer = 10, fraction = 0, message = "Artist ID must be an integer.", groups = AlbumRequest.class)
  private Integer id;

  @NotNull(message = "Artist name is required.", groups = ArtistRequest.class)
  @NotBlank(message = "Artist name is required.", groups = ArtistRequest.class)
  private String name;
}
