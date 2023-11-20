package com.merlini.musiclibrary.domain.services;

import com.merlini.musiclibrary.domain.models.Artist;
import com.merlini.musiclibrary.ports.driven.ArtistDrivenPort;
import com.merlini.musiclibrary.ports.drivers.ArtistDriverPort;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ArtistService implements ArtistDriverPort {
  private final ArtistDrivenPort artistDrivenPort;

  @Override
  public Artist createArtist(Artist artist) {
    return artistDrivenPort.createArtist(artist);
  }

  @Override
  public Artist getArtistById(Integer id) {
    return artistDrivenPort.getArtistById(id);
  }

  @Override
  public Artist updateArtist(Integer id, Artist artist) {
    return artistDrivenPort.updateArtist(id, artist);
  }

  @Override
  public void deleteArtist(Integer id) {
    artistDrivenPort.deleteArtist(id);
  }

  @Override
  public List<Artist> getAllArtists() {
    return artistDrivenPort.getAllArtists();
  }
}
