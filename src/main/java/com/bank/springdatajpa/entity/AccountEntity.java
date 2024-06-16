package com.bank.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ACCOUNT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ACCT_ID")
    int acct_id;
    @Column(name = "BALANCE")
    Integer balance;
    @Column(name = "IS_ACTIVE")
    Boolean active;

}
