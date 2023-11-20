package com.merlini.musiclibrary.adapters.drivers.mappers;

import com.merlini.musiclibrary.adapters.drivers.requests.TrackRequest;
import com.merlini.musiclibrary.adapters.drivers.responses.TrackResponse;
import com.merlini.musiclibrary.domain.models.Track;
import org.mapstruct.Mapper;

@Mapper
public interface TrackRestMapper {
  Track toTrack(TrackRequest trackRequest);

  TrackResponse toTrackResponse(Track track);
}
