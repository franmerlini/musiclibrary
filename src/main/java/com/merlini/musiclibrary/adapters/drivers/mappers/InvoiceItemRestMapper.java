package com.merlini.musiclibrary.adapters.drivers.mappers;

import com.merlini.musiclibrary.adapters.drivers.requests.InvoiceItemRequest;
import com.merlini.musiclibrary.adapters.drivers.responses.InvoiceItemResponse;
import com.merlini.musiclibrary.domain.models.InvoiceItem;
import org.mapstruct.Mapper;

@Mapper
public interface InvoiceItemRestMapper {
  InvoiceItem toInvoiceItem(InvoiceItemRequest invoiceItemRequest);

  InvoiceItemResponse toInvoiceItemResponse(InvoiceItem invoiceItem);
}
