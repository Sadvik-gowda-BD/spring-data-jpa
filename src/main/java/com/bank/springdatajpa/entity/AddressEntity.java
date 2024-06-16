package com.bank.springdatajpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ADDRESS")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ADDRESS_ID")
    private int addressId;
    @Column(name = "STATE")
    private String state;
    @Column(name = "COUNTRY")
    private String country;

    //Bi directional
    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private CustomerEntity customerEntity;

}
