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
public class ProductSubType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private boolean active;

    @NonNull
    @ManyToOne
    private ProductType productType;

}
