package com.merlini.musiclibrary.ports.driven;

import com.merlini.musiclibrary.domain.models.InvoiceItem;
import java.util.List;

public interface InvoiceItemDrivenPort {
  InvoiceItem createInvoiceItem(InvoiceItem invoiceItem);

  InvoiceItem getInvoiceItemById(Integer id);

  InvoiceItem updateInvoiceItem(Integer id, InvoiceItem invoiceItem);

  void deleteInvoiceItem(Integer id);

  List<InvoiceItem> getAllInvoiceItems();
}
