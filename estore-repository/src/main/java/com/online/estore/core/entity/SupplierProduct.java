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
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"suppler_id", "product_detail_id"}))
public class SupplierProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "suppler_id")
    private Supplier supplier;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "product_detail_id")
    private ProductDetail productDetail;

    @NonNull
    private float price;

    @NonNull
    private boolean active;

    @OneToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "product_offer_id")
    private ProductOffer productOffer;




}
