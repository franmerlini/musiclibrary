package com.merlini.musiclibrary.ports.drivers;

import com.merlini.musiclibrary.domain.models.Playlist;
import java.util.List;

public interface PlaylistDriverPort {
  Playlist createPlaylist(Playlist playlist);

  Playlist getPlaylistById(Integer id);

  Playlist updatePlaylist(Integer id, Playlist playlist);

  void deletePlaylist(Integer id);

  List<Playlist> getAllPlaylists();
}
