package com.online.estore.core.repository;

import com.online.estore.core.entity.Supplier;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SupplierRepository extends PagingAndSortingRepository<Supplier, Long> {
    @Override
    <S extends Supplier> S save(S s);
}
