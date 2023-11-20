package com.merlini.musiclibrary.ports.drivers;

import com.merlini.musiclibrary.domain.models.Track;
import java.util.List;

public interface TrackDriverPort {
  Track createTrack(Track track);

  Track getTrackById(Integer id);

  Track updateTrack(Integer id, Track track);

  void deleteTrack(Integer id);

  List<Track> getAllTracks();
}
