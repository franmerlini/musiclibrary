package com.merlini.musiclibrary.domain.models;

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
public class Invoice {
  private int id;
  private Customer customer;
  private Date invoiceDate;
  private String billingAddress;
  private String billingCity;
  private String billingState;
  private String billingCountry;
  private String billingPostalCode;
  private Float total;
}
