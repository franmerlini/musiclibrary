package com.merlini.musiclibrary.ports.drivers;

import com.merlini.musiclibrary.domain.models.Album;
import java.util.List;

public interface AlbumDriverPort {
  Album createAlbum(Album album);

  Album getAlbumById(Integer id);

  Album updateAlbum(Integer id, Album album);

  void deleteAlbum(Integer id);

  List<Album> getAllAlbums();
}
