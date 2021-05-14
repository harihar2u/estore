package com.online.estore.core.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class ProductOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @OneToOne
    private SupplierProduct supplierProduct;

    @NonNull
    private String description;

    @NonNull
    private float offerPrice;

    @NonNull
    private boolean active;

}
