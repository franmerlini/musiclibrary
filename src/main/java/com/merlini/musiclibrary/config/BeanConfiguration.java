package com.merlini.musiclibrary.config;

import com.merlini.musiclibrary.adapters.driven.GenreDrivenAdapter;
import com.merlini.musiclibrary.adapters.driven.mappers.GenrePersistenceMapper;
import com.merlini.musiclibrary.adapters.driven.repositories.GenreRepository;
import com.merlini.musiclibrary.domain.services.GenreService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
  @Bean
  public GenreDrivenAdapter genreDrivenAdapter(
      GenreRepository genreRepository,
      GenrePersistenceMapper genrePersistenceMapper
  ) {
    return new GenreDrivenAdapter(genreRepository, genrePersistenceMapper);
  }

  @Bean
  public GenreService genreService(GenreDrivenAdapter genreDrivenAdapter) {
    return new GenreService(genreDrivenAdapter);
  }
}
