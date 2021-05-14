package com.online.estore.core.repository;

import com.online.estore.core.entity.ProductDetail;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductDetailRepository extends PagingAndSortingRepository<ProductDetail, Long> {

    @Override
    <S extends ProductDetail> S save(S s);

}
