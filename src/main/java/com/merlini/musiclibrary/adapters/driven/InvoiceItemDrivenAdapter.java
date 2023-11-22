package com.merlini.musiclibrary.adapters.driven;

import static java.util.stream.StreamSupport.stream;

import com.merlini.musiclibrary.adapters.driven.entities.InvoiceEntity;
import com.merlini.musiclibrary.adapters.driven.entities.InvoiceItemEntity;
import com.merlini.musiclibrary.adapters.driven.entities.TrackEntity;
import com.merlini.musiclibrary.adapters.driven.exceptions.EntityNotFoundException;
import com.merlini.musiclibrary.adapters.driven.mappers.InvoiceItemPersistenceMapper;
import com.merlini.musiclibrary.adapters.driven.repositories.InvoiceItemRepository;
import com.merlini.musiclibrary.adapters.driven.repositories.InvoiceRepository;
import com.merlini.musiclibrary.adapters.driven.repositories.TrackRepository;
import com.merlini.musiclibrary.domain.models.InvoiceItem;
import com.merlini.musiclibrary.ports.driven.InvoiceItemDrivenPort;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InvoiceItemDrivenAdapter implements InvoiceItemDrivenPort {
  private final InvoiceItemRepository invoiceItemRepository;
  private final InvoiceItemPersistenceMapper invoiceItemPersistenceMapper;
  private final InvoiceRepository invoiceRepository;
  private final TrackRepository trackRepository;

  @Override
  public InvoiceItem createInvoiceItem(InvoiceItem invoiceItem) {
    try {
      InvoiceItemEntity invoiceItemEntity =
          invoiceItemPersistenceMapper.invoiceItemToInvoiceItemEntity(invoiceItem);
      InvoiceItemEntity savedInvoiceItemEntity = invoiceItemRepository.save(invoiceItemEntity);

      return invoiceItemPersistenceMapper.invoiceItemEntityToInvoiceItem(savedInvoiceItemEntity);
    } catch (Exception e) {
      throw new RuntimeException("Error while creating invoice item.");
    }
  }

  @Override
  public InvoiceItem getInvoiceItemById(Integer id) {
    try {
      Optional<InvoiceItemEntity> invoiceItemEntity = invoiceItemRepository.findById(id);

      if (invoiceItemEntity.isEmpty()) {
        throw new EntityNotFoundException("Invoice item not found.");
      }

      return invoiceItemPersistenceMapper.invoiceItemEntityToInvoiceItem(invoiceItemEntity.get());
    } catch (EntityNotFoundException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error while getting invoice item.");
    }
  }

  @Override
  public InvoiceItem updateInvoiceItem(Integer id, InvoiceItem invoiceItem) {
    try {
      Optional<InvoiceItemEntity> invoiceItemEntity = invoiceItemRepository.findById(id);

      if (invoiceItemEntity.isEmpty()) {
        throw new EntityNotFoundException("Invoice item not found.");
      }

      InvoiceItemEntity toUpdateInvoiceItemEntity =
          patchInvoiceItem(invoiceItemEntity.get(), invoiceItem);

      InvoiceItemEntity updatedInvoiceItemEntity =
          invoiceItemRepository.save(toUpdateInvoiceItemEntity);

      return invoiceItemPersistenceMapper.invoiceItemEntityToInvoiceItem(updatedInvoiceItemEntity);
    } catch (EntityNotFoundException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error while updating invoice item.");
    }
  }

  @Override
  public void deleteInvoiceItem(Integer id) {
    try {
      boolean exists = invoiceItemRepository.existsById(id);

      if (!exists) {
        throw new EntityNotFoundException("Invoice item not found.");
      }

      invoiceItemRepository.deleteById(id);
    } catch (EntityNotFoundException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error while deleting invoice item.");
    }
  }

  @Override
  public List<InvoiceItem> getAllInvoiceItems() {
    try {
      Iterable<InvoiceItemEntity> invoiceItemEntities = invoiceItemRepository.findAll();

      return stream(invoiceItemEntities.spliterator(), false)
          .map(invoiceItemPersistenceMapper::invoiceItemEntityToInvoiceItem)
          .toList();
    } catch (Exception e) {
      throw new RuntimeException("Error while getting all invoice items.");
    }
  }

  private InvoiceItemEntity patchInvoiceItem(InvoiceItemEntity invoiceItemEntity,
                                             InvoiceItem invoiceItem) {
    Optional<InvoiceEntity> invoiceEntity =
        invoiceRepository.findById(invoiceItem.getInvoice().getId());

    if (invoiceEntity.isEmpty()) {
      throw new EntityNotFoundException("Invoice not found.");
    }

    invoiceItemEntity.getInvoice().setId(invoiceItem.getInvoice().getId());

    Optional<TrackEntity> trackEntity = trackRepository.findById(invoiceItem.getTrack().getId());

    if (trackEntity.isEmpty()) {
      throw new EntityNotFoundException("Track not found.");
    }

    if (invoiceItem.getTrack().getId() != null) {
      invoiceItemEntity.getTrack().setId(invoiceItem.getTrack().getId());
    }

    if (invoiceItem.getUnitPrice() != null) {
      invoiceItemEntity.setUnitPrice(invoiceItem.getUnitPrice());
    }

    if (invoiceItem.getQuantity() != null) {
      invoiceItemEntity.setQuantity(invoiceItem.getQuantity());
    }

    return invoiceItemEntity;
  }
}
