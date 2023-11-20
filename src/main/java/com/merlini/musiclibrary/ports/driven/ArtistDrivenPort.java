package com.merlini.musiclibrary.ports.driven;

import com.merlini.musiclibrary.domain.models.Artist;
import java.util.List;

public interface ArtistDrivenPort {
  Artist createArtist(Artist artist);

  Artist getArtistById(Integer id);

  Artist updateArtist(Integer id, Artist artist);

  void deleteArtist(Integer id);

  List<Artist> getAllArtists();
}
