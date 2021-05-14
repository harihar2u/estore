package com.online.estore.core.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames="name"))
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private boolean active;

    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private Collection<ProductSubType> productSubTypes = new HashSet<ProductSubType>();


}
