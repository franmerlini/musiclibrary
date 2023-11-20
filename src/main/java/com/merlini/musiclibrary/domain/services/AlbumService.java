package com.merlini.musiclibrary.domain.services;

import com.merlini.musiclibrary.domain.models.Album;
import com.merlini.musiclibrary.ports.driven.AlbumDrivenPort;
import com.merlini.musiclibrary.ports.drivers.AlbumDriverPort;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AlbumService implements AlbumDriverPort {
  private final AlbumDrivenPort albumDrivenPort;

  @Override
  public Album createAlbum(Album album) {
    return albumDrivenPort.createAlbum(album);
  }

  @Override
  public Album getAlbumById(Integer id) {
    return albumDrivenPort.getAlbumById(id);
  }

  @Override
  public Album updateAlbum(Integer id, Album album) {
    return albumDrivenPort.updateAlbum(id, album);
  }

  @Override
  public void deleteAlbum(Integer id) {
    albumDrivenPort.deleteAlbum(id);
  }

  @Override
  public List<Album> getAllAlbums() {
    return albumDrivenPort.getAllAlbums();
  }
}
