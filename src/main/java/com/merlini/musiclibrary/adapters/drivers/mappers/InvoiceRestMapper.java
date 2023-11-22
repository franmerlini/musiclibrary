package com.merlini.musiclibrary.adapters.drivers.mappers;

import com.merlini.musiclibrary.adapters.drivers.requests.InvoiceRequest;
import com.merlini.musiclibrary.adapters.drivers.responses.InvoiceResponse;
import com.merlini.musiclibrary.domain.models.Invoice;
import org.mapstruct.Mapper;

@Mapper
public interface InvoiceRestMapper {
  Invoice toInvoice(InvoiceRequest invoiceRequest);

  InvoiceResponse toInvoiceResponse(Invoice invoice);
}
