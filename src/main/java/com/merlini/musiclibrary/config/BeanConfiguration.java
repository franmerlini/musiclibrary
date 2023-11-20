package com.merlini.musiclibrary.config;

import com.merlini.musiclibrary.adapters.driven.AlbumDrivenAdapter;
import com.merlini.musiclibrary.adapters.driven.ArtistDrivenAdapter;
import com.merlini.musiclibrary.adapters.driven.GenreDrivenAdapter;
import com.merlini.musiclibrary.adapters.driven.mappers.AlbumPersistenceMapper;
import com.merlini.musiclibrary.adapters.driven.mappers.ArtistPersistenceMapper;
import com.merlini.musiclibrary.adapters.driven.mappers.GenrePersistenceMapper;
import com.merlini.musiclibrary.adapters.driven.repositories.AlbumRepository;
import com.merlini.musiclibrary.adapters.driven.repositories.ArtistRepository;
import com.merlini.musiclibrary.adapters.driven.repositories.GenreRepository;
import com.merlini.musiclibrary.domain.services.AlbumService;
import com.merlini.musiclibrary.domain.services.ArtistService;
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

  @Bean
  public ArtistDrivenAdapter artistDrivenAdapter(
      ArtistRepository artistRepository,
      ArtistPersistenceMapper artistPersistenceMapper
  ) {
    return new ArtistDrivenAdapter(artistRepository, artistPersistenceMapper);
  }

  @Bean
  public ArtistService artistService(ArtistDrivenAdapter artistDrivenAdapter) {
    return new ArtistService(artistDrivenAdapter);
  }

  @Bean
  public AlbumDrivenAdapter albumDrivenAdapter(
      AlbumRepository albumRepository,
      AlbumPersistenceMapper albumPersistenceMapper,
      ArtistRepository artistRepository
  ) {
    return new AlbumDrivenAdapter(albumRepository, albumPersistenceMapper, artistRepository);
  }

  @Bean
  public AlbumService albumService(AlbumDrivenAdapter albumDrivenAdapter) {
    return new AlbumService(albumDrivenAdapter);
  }
}
