package com.merlini.musiclibrary.adapters.drivers.responses;

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
public class TrackResponse {
  private Integer id;
  private String name;
  private AlbumResponse album;
  private MediaTypeResponse mediaType;
  private GenreResponse genre;
  private String composer;
  private Integer milliseconds;
  private Integer bytes;
  private Float unitPrice;
}
