package com.merlini.musiclibrary.adapters.drivers.requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
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
public class TrackRequest {
  @NotNull(message = "Name is required.")
  @NotBlank(message = "Name is required.")
  private String name;

  @Valid
  @NotNull(message = "Album is required.")
  private AlbumRequest album;

  @Valid
  @NotNull(message = "Media type is required.")
  private MediaTypeRequest mediaType;

  @Valid
  @NotNull(message = "Genre is required.")
  private GenreRequest genre;

  @NotNull(message = "Composer is required.")
  @NotBlank(message = "Composer is required.")
  private String composer;

  @NotNull(message = "Milliseconds is required.")
  @Min(value = 0, message = "Milliseconds must be greater than 0.")
  @Digits(integer = 10, fraction = 0, message = "Milliseconds must be an integer.")
  private Integer milliseconds;

  @NotNull(message = "Bytes is required.")
  @Min(value = 0, message = "Bytes must be greater than 0.")
  @Digits(integer = 10, fraction = 0, message = "Bytes must be an integer.")
  private Integer bytes;

  @NotNull(message = "Unit price is required.")
  @Min(value = 0, message = "Unit price must be greater than 0.")
  @Digits(integer = 10, fraction = 2, message = "Unit price must be a decimal.")
  private Float unitPrice;
}
