package com.merlini.musiclibrary.adapters.drivers.requests;

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
  @NotNull(message = "Media type name is required.")
  @NotBlank(message = "Media type name is required.")
  private String name;
}
