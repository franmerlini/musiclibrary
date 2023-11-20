package com.merlini.musiclibrary.ports.drivers;

import com.merlini.musiclibrary.domain.models.Artist;
import java.util.List;

public interface ArtistDriverPort {
  Artist createArtist(Artist artist);

  Artist getArtistById(Integer id);

  Artist updateArtist(Integer id, Artist artist);

  void deleteArtist(Integer id);

  List<Artist> getAllArtists();
}
