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
public class InvoiceItem {
  private Integer id;
  private Invoice invoice;
  private Track track;
  private Float unitPrice;
  private Integer quantity;
}
