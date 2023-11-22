package com.merlini.musiclibrary.adapters.drivers;

import com.merlini.musiclibrary.adapters.drivers.mappers.InvoiceItemRestMapper;
import com.merlini.musiclibrary.adapters.drivers.requests.InvoiceItemRequest;
import com.merlini.musiclibrary.adapters.drivers.responses.InvoiceItemResponse;
import com.merlini.musiclibrary.domain.models.InvoiceItem;
import com.merlini.musiclibrary.ports.drivers.InvoiceItemDriverPort;
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
@RequestMapping("/api/invoiceItems")
public class InvoiceItemRestDriverAdapter {
  private final InvoiceItemDriverPort invoiceItemDriverPort;
  private final InvoiceItemRestMapper invoiceItemRestMapper;

  @PostMapping
  public ResponseEntity<InvoiceItemResponse> createInvoiceItem(
      @RequestBody @Valid InvoiceItemRequest invoiceItemRequest) {
    InvoiceItem invoiceItem = invoiceItemRestMapper.toInvoiceItem(invoiceItemRequest);
    InvoiceItem createdInvoiceItem = invoiceItemDriverPort.createInvoiceItem(invoiceItem);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(invoiceItemRestMapper.toInvoiceItemResponse(createdInvoiceItem));
  }

  @GetMapping("/{id}")
  public ResponseEntity<InvoiceItemResponse> getInvoiceItemById(@PathVariable int id) {
    InvoiceItem invoiceItem = invoiceItemDriverPort.getInvoiceItemById(id);
    return ResponseEntity.ok(invoiceItemRestMapper.toInvoiceItemResponse(invoiceItem));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<InvoiceItemResponse> updateInvoiceItem(@PathVariable int id,
                                                               @RequestBody
                                                               @Valid InvoiceItemRequest invoiceItemRequest) {
    InvoiceItem invoiceItem = invoiceItemRestMapper.toInvoiceItem(invoiceItemRequest);
    InvoiceItem updatedInvoiceItem = invoiceItemDriverPort.updateInvoiceItem(id, invoiceItem);
    return ResponseEntity.ok(invoiceItemRestMapper.toInvoiceItemResponse(updatedInvoiceItem));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<InvoiceItemResponse> deleteInvoiceItem(@PathVariable int id) {
    invoiceItemDriverPort.deleteInvoiceItem(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping
  public ResponseEntity<List<InvoiceItemResponse>> getAllInvoiceItems() {
    List<InvoiceItem> invoiceItems = invoiceItemDriverPort.getAllInvoiceItems();
    return ResponseEntity.ok(
        invoiceItems.stream().map(invoiceItemRestMapper::toInvoiceItemResponse).toList());
  }
}
