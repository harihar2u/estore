package com.online.estore.core.repository;

import com.online.estore.core.entity.ProductType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductTypeRepository extends PagingAndSortingRepository<ProductType, Long> {

    @Override
    <S extends ProductType> S save(S s);
}
