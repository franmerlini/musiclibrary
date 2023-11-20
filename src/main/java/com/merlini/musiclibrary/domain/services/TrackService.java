package com.merlini.musiclibrary.domain.services;

import com.merlini.musiclibrary.domain.models.Track;
import com.merlini.musiclibrary.ports.driven.TrackDrivenPort;
import com.merlini.musiclibrary.ports.drivers.TrackDriverPort;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TrackService implements TrackDriverPort {
  private final TrackDrivenPort trackDrivenPort;

  @Override
  public Track createTrack(Track track) {
    return trackDrivenPort.createTrack(track);
  }

  @Override
  public Track getTrackById(Integer id) {
    return trackDrivenPort.getTrackById(id);
  }

  @Override
  public Track updateTrack(Integer id, Track track) {
    return trackDrivenPort.updateTrack(id, track);
  }

  @Override
  public void deleteTrack(Integer id) {
    trackDrivenPort.deleteTrack(id);
  }

  @Override
  public List<Track> getAllTracks() {
    return trackDrivenPort.getAllTracks();
  }
}
