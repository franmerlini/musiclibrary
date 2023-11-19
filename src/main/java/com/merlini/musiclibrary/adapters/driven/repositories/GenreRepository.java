package com.merlini.musiclibrary.adapters.driven.repositories;

import com.merlini.musiclibrary.adapters.driven.entities.GenreEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends CrudRepository<GenreEntity, Integer> {
}
