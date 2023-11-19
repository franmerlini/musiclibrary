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
@Table(name = "tracks")
public class TrackEntity {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "TrackId")
  private int id;

  @Basic
  @Column(name = "Name")
  private String name;

  @ManyToOne
  @JoinColumn(name = "AlbumId")
  private AlbumEntity album;

  @ManyToOne
  @JoinColumn(name = "MediaTypeId")
  private MediaTypeEntity mediaType;

  @ManyToOne
  @JoinColumn(name = "GenreId")
  private GenreEntity genre;

  @Basic
  @Column(name = "Composer")
  private String composer;

  @Basic
  @Column(name = "Milliseconds")
  private int milliseconds;

  @Basic
  @Column(name = "Bytes")
  private int bytes;

  @Basic
  @Column(name = "UnitPrice")
  private float unitPrice;
}
