package com.merlini.musiclibrary.domain.models;

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
public class Track {
  private Integer id;
  private String name;
  private Album album;
  private MediaType mediaType;
  private Genre genre;
  private String composer;
  private Integer milliseconds;
  private Integer bytes;
  private Float unitPrice;
}
