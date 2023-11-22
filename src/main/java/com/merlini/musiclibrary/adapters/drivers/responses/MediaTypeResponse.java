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
public class MediaTypeResponse {
  private Integer id;
  private String name;
}
