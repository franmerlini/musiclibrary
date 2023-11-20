package com.merlini.musiclibrary.adapters.driven.repositories;

import com.merlini.musiclibrary.adapters.driven.entities.ArtistEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends CrudRepository<ArtistEntity, Integer> {
}
