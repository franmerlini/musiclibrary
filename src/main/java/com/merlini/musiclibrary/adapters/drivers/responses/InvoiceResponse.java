package com.merlini.musiclibrary.adapters.drivers.responses;

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
public class InvoiceResponse {
  private Integer id;
  private CustomerResponse customer;
  private Date invoiceDate;
  private String billingAddress;
  private String billingCity;
  private String billingState;
  private String billingCountry;
  private String billingPostalCode;
  private Float total;
}
