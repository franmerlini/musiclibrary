package com.merlini.musiclibrary.adapters.driven.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "playlists")
public class PlaylistEntity {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "PlaylistId")
  private Integer id;

  @Basic
  @Column(name = "Name")
  private String name;

  @ManyToMany
  @JoinTable(
      name = "playlist_track",
      joinColumns = @JoinColumn(name = "PlaylistId"),
      inverseJoinColumns = @JoinColumn(name = "TrackId")
  )
  private List<TrackEntity> tracks;
}
