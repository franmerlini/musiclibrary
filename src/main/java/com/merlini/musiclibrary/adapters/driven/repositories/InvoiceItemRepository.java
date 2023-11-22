package com.merlini.musiclibrary.adapters.driven.repositories;

import com.merlini.musiclibrary.adapters.driven.entities.InvoiceItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceItemRepository extends CrudRepository<InvoiceItemEntity, Integer> {
}
