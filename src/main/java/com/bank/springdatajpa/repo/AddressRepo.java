package com.bank.springdatajpa.repo;

import com.bank.springdatajpa.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<AddressEntity,Integer> {
}
