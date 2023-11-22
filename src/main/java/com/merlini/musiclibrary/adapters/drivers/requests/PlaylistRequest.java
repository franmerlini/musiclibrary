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
public class PlaylistRequest {
  @NotNull(message = "Playlist ID is required.")
  @Digits(integer = 10, fraction = 0, message = "Playlist ID must be an integer.")
  private Integer id;

  @NotNull(message = "Playlist name is required.", groups = PlaylistRequest.class)
  @NotBlank(message = "Playlist name is required.", groups = PlaylistRequest.class)
  private String name;
}
