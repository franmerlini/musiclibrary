package com.merlini.musiclibrary.adapters.driven.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invoices")
public class InvoiceEntity {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "InvoiceId")
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "CustomerId")
  private CustomerEntity customer;

  @Basic
  @Column(name = "InvoiceDate")
  private Date invoiceDate;

  @Basic
  @Column(name = "BillingAddress")
  private String billingAddress;

  @Basic
  @Column(name = "BillingCity")
  private String billingCity;

  @Basic
  @Column(name = "BillingState")
  private String billingState;

  @Basic
  @Column(name = "BillingCountry")
  private String billingCountry;

  @Basic
  @Column(name = "BillingPostalCode")
  private String billingPostalCode;

  @Basic
  @Column(name = "Total")
  private Float total;
}
