package com.merlini.musiclibrary.domain.services;

import com.merlini.musiclibrary.domain.models.Invoice;
import com.merlini.musiclibrary.ports.driven.InvoiceDrivenPort;
import com.merlini.musiclibrary.ports.drivers.InvoiceDriverPort;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InvoiceService implements InvoiceDriverPort {
  private final InvoiceDrivenPort invoiceDrivenPort;

  @Override
  public Invoice createInvoice(Invoice invoice) {
    return invoiceDrivenPort.createInvoice(invoice);
  }

  @Override
  public Invoice getInvoiceById(Integer id) {
    return invoiceDrivenPort.getInvoiceById(id);
  }

  @Override
  public Invoice updateInvoice(Integer id, Invoice invoice) {
    return invoiceDrivenPort.updateInvoice(id, invoice);
  }

  @Override
  public void deleteInvoice(Integer id) {
    invoiceDrivenPort.deleteInvoice(id);
  }

  @Override
  public List<Invoice> getAllInvoices() {
    return invoiceDrivenPort.getAllInvoices();
  }
}
