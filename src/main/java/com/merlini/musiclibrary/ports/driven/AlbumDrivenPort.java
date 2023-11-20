package com.merlini.musiclibrary.ports.driven;

import com.merlini.musiclibrary.domain.models.Album;
import java.util.List;

public interface AlbumDrivenPort {
  Album createAlbum(Album album);

  Album getAlbumById(Integer id);

  Album updateAlbum(Integer id, Album album);

  void deleteAlbum(Integer id);

  List<Album> getAllAlbums();
}
