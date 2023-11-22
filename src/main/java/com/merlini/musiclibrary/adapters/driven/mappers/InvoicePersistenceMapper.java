package com.merlini.musiclibrary.adapters.driven.mappers;

import com.merlini.musiclibrary.adapters.driven.entities.InvoiceEntity;
import com.merlini.musiclibrary.domain.models.Invoice;
import org.mapstruct.Mapper;

@Mapper
public interface InvoicePersistenceMapper {
  InvoiceEntity invoiceToInvoiceEntity(Invoice invoice);

  Invoice invoiceEntityToInvoice(InvoiceEntity invoiceEntity);
}
