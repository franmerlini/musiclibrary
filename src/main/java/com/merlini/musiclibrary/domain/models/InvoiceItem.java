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
  private int id;
  private Invoice invoice;
  private Track track;
  private float unitPrice;
  private int quantity;
}
