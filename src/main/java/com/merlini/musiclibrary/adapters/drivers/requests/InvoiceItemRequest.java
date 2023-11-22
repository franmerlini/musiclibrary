package com.merlini.musiclibrary.adapters.drivers.requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
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
public class InvoiceItemRequest {
  @Valid
  @NotNull(message = "Invoice is required.")
  private InvoiceRequest invoice;

  @Valid
  @NotNull(message = "Track is required.")
  private TrackRequest track;

  @NotNull(message = "Unit price is required.")
  @Digits(integer = 5, fraction = 2, message = "Unit price must be a number with up to 5 digits and 2 decimals.")
  @Min(value = 0, message = "Unit price must be greater than or equal to 0.")
  private Float unitPrice;

  @NotNull(message = "Quantity is required.")
  @Digits(integer = 5, fraction = 0, message = "Quantity must be a number with up to 5 digits and no decimals.")
  @Min(value = 1, message = "Quantity must be greater than 0.")
  private Integer quantity;
}
