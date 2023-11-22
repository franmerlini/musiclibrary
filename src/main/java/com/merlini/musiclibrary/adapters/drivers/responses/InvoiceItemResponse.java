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
public class InvoiceItemResponse {
  private Integer id;
  private InvoiceResponse invoice;
  private TrackResponse track;
  private Float unitPrice;
  private Integer quantity;
}
