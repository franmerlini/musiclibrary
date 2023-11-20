package com.merlini.musiclibrary.ports.driven;

import com.merlini.musiclibrary.domain.models.Track;
import java.util.List;

public interface TrackDrivenPort {
  Track createTrack(Track track);

  Track getTrackById(Integer id);

  Track updateTrack(Integer id, Track track);

  void deleteTrack(Integer id);

  List<Track> getAllTracks();
}
