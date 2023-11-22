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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invoice_items")
public class InvoiceItemEntity {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "InvoiceLineId")
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "InvoiceId")
  private InvoiceEntity invoice;

  @ManyToOne
  @JoinColumn(name = "TrackId")
  private TrackEntity track;

  @Basic
  @Column(name = "UnitPrice")
  private Float unitPrice;

  @Basic
  @Column(name = "Quantity")
  private Integer quantity;
}
