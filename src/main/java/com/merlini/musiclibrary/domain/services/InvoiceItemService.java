package com.merlini.musiclibrary.domain.services;

import com.merlini.musiclibrary.domain.models.InvoiceItem;
import com.merlini.musiclibrary.ports.driven.InvoiceItemDrivenPort;
import com.merlini.musiclibrary.ports.drivers.InvoiceItemDriverPort;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InvoiceItemService implements InvoiceItemDriverPort {
  private final InvoiceItemDrivenPort invoiceItemDrivenPort;

  @Override
  public InvoiceItem createInvoiceItem(InvoiceItem invoiceItem) {
    return invoiceItemDrivenPort.createInvoiceItem(invoiceItem);
  }

  @Override
  public InvoiceItem getInvoiceItemById(Integer id) {
    return invoiceItemDrivenPort.getInvoiceItemById(id);
  }

  @Override
  public InvoiceItem updateInvoiceItem(Integer id, InvoiceItem invoiceItem) {
    return invoiceItemDrivenPort.updateInvoiceItem(id, invoiceItem);
  }

  @Override
  public void deleteInvoiceItem(Integer id) {
    invoiceItemDrivenPort.deleteInvoiceItem(id);
  }

  @Override
  public List<InvoiceItem> getAllInvoiceItems() {
    return invoiceItemDrivenPort.getAllInvoiceItems();
  }
}
