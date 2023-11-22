package com.merlini.musiclibrary.ports.drivers;

import com.merlini.musiclibrary.domain.models.Invoice;
import java.util.List;

public interface InvoiceDriverPort {
  Invoice createInvoice(Invoice invoice);

  Invoice getInvoiceById(Integer id);

  Invoice updateInvoice(Integer id, Invoice invoice);

  void deleteInvoice(Integer id);

  List<Invoice> getAllInvoices();
}
