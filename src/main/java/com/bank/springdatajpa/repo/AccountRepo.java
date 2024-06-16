package com.bank.springdatajpa.repo;

import com.bank.springdatajpa.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<AccountEntity,Integer> {
}
