package com.merlini.musiclibrary.adapters.driven.mappers;

import com.merlini.musiclibrary.adapters.driven.entities.TrackEntity;
import com.merlini.musiclibrary.domain.models.Track;
import org.mapstruct.Mapper;

@Mapper
public interface TrackPersistenceMapper {
  TrackEntity trackToTrackEntity(Track track);

  Track trackEntityToTrack(TrackEntity trackEntity);
}
