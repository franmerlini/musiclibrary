package com.merlini.musiclibrary.adapters.driven;

import static java.util.stream.StreamSupport.stream;

import com.merlini.musiclibrary.adapters.driven.entities.InvoiceEntity;
import com.merlini.musiclibrary.adapters.driven.exceptions.EntityNotFoundException;
import com.merlini.musiclibrary.adapters.driven.mappers.InvoicePersistenceMapper;
import com.merlini.musiclibrary.adapters.driven.repositories.InvoiceRepository;
import com.merlini.musiclibrary.domain.models.Invoice;
import com.merlini.musiclibrary.ports.driven.InvoiceDrivenPort;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InvoiceDrivenAdapter implements InvoiceDrivenPort {
  private final InvoiceRepository invoiceRepository;
  private final InvoicePersistenceMapper invoicePersistenceMapper;

  @Override
  public Invoice createInvoice(Invoice invoice) {
    try {
      InvoiceEntity invoiceEntity = invoicePersistenceMapper.invoiceToInvoiceEntity(invoice);
      InvoiceEntity savedInvoiceEntity = this.invoiceRepository.save(invoiceEntity);

      return invoicePersistenceMapper.invoiceEntityToInvoice(savedInvoiceEntity);
    } catch (Exception e) {
      throw new RuntimeException("Error while creating invoice.");
    }
  }

  @Override
  public Invoice getInvoiceById(Integer id) {
    try {
      Optional<InvoiceEntity> invoiceEntity = this.invoiceRepository.findById(id);

      if (invoiceEntity.isEmpty()) {
        throw new EntityNotFoundException("Invoice not found.");
      }

      return invoicePersistenceMapper.invoiceEntityToInvoice(invoiceEntity.get());
    } catch (EntityNotFoundException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error while getting invoice.");
    }
  }

  @Override
  public Invoice updateInvoice(Integer id, Invoice invoice) {
    try {
      Optional<InvoiceEntity> invoiceEntity = this.invoiceRepository.findById(id);

      if (invoiceEntity.isEmpty()) {
        throw new EntityNotFoundException("Invoice not found.");
      }

      InvoiceEntity toUpdateInvoiceEntity =
          invoicePersistenceMapper.invoiceToInvoiceEntity(invoice);
      InvoiceEntity updatedInvoiceEntity = this.invoiceRepository.save(toUpdateInvoiceEntity);

      return invoicePersistenceMapper.invoiceEntityToInvoice(updatedInvoiceEntity);
    } catch (EntityNotFoundException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error while updating invoice.");
    }
  }

  @Override
  public void deleteInvoice(Integer id) {
    try {
      boolean exists = this.invoiceRepository.existsById(id);

      if (!exists) {
        throw new EntityNotFoundException("Invoice not found.");
      }

      this.invoiceRepository.deleteById(id);
    } catch (EntityNotFoundException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error while deleting invoice.");
    }
  }

  @Override
  public List<Invoice> getAllInvoices() {
    try {
      Iterable<InvoiceEntity> invoiceEntities = this.invoiceRepository.findAll();

      return stream(invoiceEntities.spliterator(), false)
          .map(invoicePersistenceMapper::invoiceEntityToInvoice)
          .toList();
    } catch (Exception e) {
      throw new RuntimeException("Error while getting all invoices.");
    }
  }
}
