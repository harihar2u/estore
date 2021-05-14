package com.online.estore.core.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    @OneToOne(cascade = CascadeType.ALL)
    private Address supplierAddress;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    private Collection<SupplierProduct> supplierProducts;

    @NonNull
    private boolean active;

    private LocalDateTime createdDate = LocalDateTime.now();


}
