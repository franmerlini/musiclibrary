package com.merlini.musiclibrary.adapters.driven.mappers;

import com.merlini.musiclibrary.adapters.driven.entities.InvoiceItemEntity;
import com.merlini.musiclibrary.domain.models.InvoiceItem;
import org.mapstruct.Mapper;

@Mapper
public interface InvoiceItemPersistenceMapper {
  InvoiceItemEntity invoiceItemToInvoiceItemEntity(InvoiceItem invoiceItem);

  InvoiceItem invoiceItemEntityToInvoiceItem(InvoiceItemEntity invoiceItemEntity);
}
