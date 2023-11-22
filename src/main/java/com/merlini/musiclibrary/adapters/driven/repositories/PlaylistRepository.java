package com.merlini.musiclibrary.adapters.driven.repositories;

import com.merlini.musiclibrary.adapters.driven.entities.PlaylistEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends CrudRepository<PlaylistEntity, Integer> {
}
