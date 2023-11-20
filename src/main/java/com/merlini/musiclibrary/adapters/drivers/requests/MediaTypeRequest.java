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
public class MediaTypeRequest {
  @NotNull(message = "Media type ID is required.", groups = TrackRequest.class)
  @Digits(integer = 10, fraction = 0, message = "Media type ID must be an integer.", groups = TrackRequest.class)
  private Integer id;

  @NotNull(message = "Media type name is required.", groups = MediaTypeRequest.class)
  @NotBlank(message = "Media type name is required.", groups = MediaTypeRequest.class)
  private String name;
}
