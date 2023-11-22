package com.merlini.musiclibrary.adapters.drivers.requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
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
public class InvoiceRequest {
  private Integer id;

  @Valid
  private CustomerRequest customer;

  @NotNull(message = "Invoice date is required.", groups = InvoiceRequest.class)
  private Date invoiceDate;

  @NotBlank(message = "Billing address name is required.", groups = InvoiceRequest.class)
  private String billingAddress;

  @NotBlank(message = "Billing city is required.", groups = InvoiceRequest.class)
  private String billingCity;

  @NotBlank(message = "Billing state is required.", groups = InvoiceRequest.class)
  private String billingState;

  @NotBlank(message = "Billing country is required.", groups = InvoiceRequest.class)
  private String billingCountry;

  @NotBlank(message = "Billing postal code is required.", groups = InvoiceRequest.class)
  private String billingPostalCode;

  @NotNull(message = "Total is required.", groups = InvoiceRequest.class)
  @Digits(integer = 10, fraction = 2, message = "Total must be a number.", groups = InvoiceRequest.class)
  private Float total;
}
