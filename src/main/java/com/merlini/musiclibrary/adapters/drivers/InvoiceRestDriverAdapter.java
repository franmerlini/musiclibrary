package com.merlini.musiclibrary.adapters.drivers;

import com.merlini.musiclibrary.adapters.drivers.mappers.InvoiceRestMapper;
import com.merlini.musiclibrary.adapters.drivers.requests.InvoiceRequest;
import com.merlini.musiclibrary.adapters.drivers.responses.InvoiceResponse;
import com.merlini.musiclibrary.domain.models.Invoice;
import com.merlini.musiclibrary.ports.drivers.InvoiceDriverPort;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/invoices")
public class InvoiceRestDriverAdapter {
  private final InvoiceDriverPort invoiceDriverPort;
  private final InvoiceRestMapper invoiceRestMapper;

  @PostMapping
  public ResponseEntity<InvoiceResponse> createInvoice(
      @RequestBody @Valid InvoiceRequest invoiceRequest) {
    Invoice invoice = invoiceRestMapper.toInvoice(invoiceRequest);
    Invoice createdInvoice = invoiceDriverPort.createInvoice(invoice);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(invoiceRestMapper.toInvoiceResponse(createdInvoice));
  }

  @GetMapping("/{id}")
  public ResponseEntity<InvoiceResponse> getInvoiceById(@PathVariable int id) {
    Invoice invoice = invoiceDriverPort.getInvoiceById(id);
    return ResponseEntity.ok(invoiceRestMapper.toInvoiceResponse(invoice));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<InvoiceResponse> updateInvoice(@PathVariable int id,
                                                       @RequestBody
                                                       @Valid InvoiceRequest invoiceRequest) {
    Invoice invoice = invoiceRestMapper.toInvoice(invoiceRequest);
    Invoice updatedInvoice = invoiceDriverPort.updateInvoice(id, invoice);
    return ResponseEntity.ok(invoiceRestMapper.toInvoiceResponse(updatedInvoice));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<InvoiceResponse> deleteInvoice(@PathVariable int id) {
    invoiceDriverPort.deleteInvoice(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping
  public ResponseEntity<List<InvoiceResponse>> getAllInvoices() {
    List<Invoice> invoices = invoiceDriverPort.getAllInvoices();
    return ResponseEntity.ok(invoices.stream().map(invoiceRestMapper::toInvoiceResponse).toList());
  }
}
