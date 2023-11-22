package com.merlini.musiclibrary.ports.driven;

import com.merlini.musiclibrary.domain.models.Playlist;
import java.util.List;

public interface PlaylistDrivenPort {
  Playlist createPlaylist(Playlist playlist);

  Playlist getPlaylistById(Integer id);

  Playlist updatePlaylist(Integer id, Playlist playlist);

  void deletePlaylist(Integer id);

  List<Playlist> getAllPlaylists();
}
