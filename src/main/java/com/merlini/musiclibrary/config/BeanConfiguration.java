package com.merlini.musiclibrary.config;

import com.merlini.musiclibrary.adapters.driven.AlbumDrivenAdapter;
import com.merlini.musiclibrary.adapters.driven.ArtistDrivenAdapter;
import com.merlini.musiclibrary.adapters.driven.CustomerDrivenAdapter;
import com.merlini.musiclibrary.adapters.driven.EmployeeDrivenAdapter;
import com.merlini.musiclibrary.adapters.driven.GenreDrivenAdapter;
import com.merlini.musiclibrary.adapters.driven.InvoiceDrivenAdapter;
import com.merlini.musiclibrary.adapters.driven.MediaTypeDrivenAdapter;
import com.merlini.musiclibrary.adapters.driven.TrackDrivenAdapter;
import com.merlini.musiclibrary.adapters.driven.mappers.AlbumPersistenceMapper;
import com.merlini.musiclibrary.adapters.driven.mappers.ArtistPersistenceMapper;
import com.merlini.musiclibrary.adapters.driven.mappers.CustomerPersistenceMapper;
import com.merlini.musiclibrary.adapters.driven.mappers.EmployeePersistenceMapper;
import com.merlini.musiclibrary.adapters.driven.mappers.GenrePersistenceMapper;
import com.merlini.musiclibrary.adapters.driven.mappers.InvoicePersistenceMapper;
import com.merlini.musiclibrary.adapters.driven.mappers.MediaTypePersistenceMapper;
import com.merlini.musiclibrary.adapters.driven.mappers.TrackPersistenceMapper;
import com.merlini.musiclibrary.adapters.driven.repositories.AlbumRepository;
import com.merlini.musiclibrary.adapters.driven.repositories.ArtistRepository;
import com.merlini.musiclibrary.adapters.driven.repositories.CustomerRepository;
import com.merlini.musiclibrary.adapters.driven.repositories.EmployeeRepository;
import com.merlini.musiclibrary.adapters.driven.repositories.GenreRepository;
import com.merlini.musiclibrary.adapters.driven.repositories.InvoiceRepository;
import com.merlini.musiclibrary.adapters.driven.repositories.MediaTypeRepository;
import com.merlini.musiclibrary.adapters.driven.repositories.TrackRepository;
import com.merlini.musiclibrary.domain.services.AlbumService;
import com.merlini.musiclibrary.domain.services.ArtistService;
import com.merlini.musiclibrary.domain.services.CustomerService;
import com.merlini.musiclibrary.domain.services.EmployeeService;
import com.merlini.musiclibrary.domain.services.GenreService;
import com.merlini.musiclibrary.domain.services.InvoiceService;
import com.merlini.musiclibrary.domain.services.MediaTypeService;
import com.merlini.musiclibrary.domain.services.TrackService;
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

  @Bean
  public MediaTypeDrivenAdapter mediaTypeDrivenAdapter(
      MediaTypeRepository mediaTypeRepository,
      MediaTypePersistenceMapper mediaTypePersistenceMapper
  ) {
    return new MediaTypeDrivenAdapter(mediaTypeRepository, mediaTypePersistenceMapper);
  }

  @Bean
  public MediaTypeService mediaTypeService(MediaTypeDrivenAdapter mediaTypeDrivenAdapter) {
    return new MediaTypeService(mediaTypeDrivenAdapter);
  }

  @Bean
  public TrackDrivenAdapter trackDrivenAdapter(
      TrackRepository trackRepository,
      TrackPersistenceMapper trackPersistenceMapper,
      GenreRepository genreRepository,
      MediaTypeRepository mediaTypeRepository,
      AlbumRepository albumRepository
  ) {
    return new TrackDrivenAdapter(trackRepository, trackPersistenceMapper, genreRepository,
        mediaTypeRepository, albumRepository);
  }

  @Bean
  public TrackService trackService(TrackDrivenAdapter trackDrivenAdapter) {
    return new TrackService(trackDrivenAdapter);
  }

  @Bean
  public EmployeeDrivenAdapter employeeDrivenAdapter(
      EmployeeRepository employeeRepository,
      EmployeePersistenceMapper employeePersistenceMapper
  ) {
    return new EmployeeDrivenAdapter(employeeRepository, employeePersistenceMapper);
  }

  @Bean
  public EmployeeService employeeService(EmployeeDrivenAdapter employeeDrivenAdapter) {
    return new EmployeeService(employeeDrivenAdapter);
  }

  @Bean
  public CustomerDrivenAdapter customerDrivenAdapter(
      CustomerRepository customerRepository,
      CustomerPersistenceMapper customerPersistenceMapper
  ) {
    return new CustomerDrivenAdapter(customerRepository, customerPersistenceMapper);
  }

  @Bean
  public CustomerService customerService(CustomerDrivenAdapter customerDrivenAdapter) {
    return new CustomerService(customerDrivenAdapter);
  }

  @Bean
  public InvoiceDrivenAdapter invoiceDrivenAdapter(
      InvoiceRepository invoiceRepository,
      InvoicePersistenceMapper invoicePersistenceMapper
  ) {
    return new InvoiceDrivenAdapter(invoiceRepository, invoicePersistenceMapper);
  }

  @Bean
  public InvoiceService invoiceService(InvoiceDrivenAdapter invoiceDrivenAdapter) {
    return new InvoiceService(invoiceDrivenAdapter);
  }
}
