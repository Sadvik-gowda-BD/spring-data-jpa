package com.bank.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Builder
public class ProductTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_ID")
    private int productId;
    @Column(name = "NAME")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "customer_product_type_map",
            joinColumns = @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID"),
            inverseJoinColumns = @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")
    )
    private Set<CustomerEntity> customerEntities;
}
