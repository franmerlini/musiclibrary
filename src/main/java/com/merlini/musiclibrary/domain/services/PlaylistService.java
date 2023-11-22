package com.merlini.musiclibrary.domain.services;

import com.merlini.musiclibrary.domain.models.Playlist;
import com.merlini.musiclibrary.ports.driven.PlaylistDrivenPort;
import com.merlini.musiclibrary.ports.drivers.PlaylistDriverPort;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlaylistService implements PlaylistDriverPort {
  private final PlaylistDrivenPort playlistDrivenPort;

  @Override
  public Playlist createPlaylist(Playlist playlist) {
    return playlistDrivenPort.createPlaylist(playlist);
  }

  @Override
  public Playlist getPlaylistById(Integer id) {
    return playlistDrivenPort.getPlaylistById(id);
  }

  @Override
  public Playlist updatePlaylist(Integer id, Playlist playlist) {
    return playlistDrivenPort.updatePlaylist(id, playlist);
  }

  @Override
  public void deletePlaylist(Integer id) {
    playlistDrivenPort.deletePlaylist(id);
  }

  @Override
  public List<Playlist> getAllPlaylists() {
    return playlistDrivenPort.getAllPlaylists();
  }
}
