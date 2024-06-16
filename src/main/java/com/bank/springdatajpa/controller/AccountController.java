package com.bank.springdatajpa.controller;


import com.bank.springdatajpa.entity.AccountEntity;
import com.bank.springdatajpa.repo.AccountRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountRepo accountRepo;

    @GetMapping("/{acctNum}")
    public AccountEntity geAccount(@PathVariable("acctNum") int acctNUm){
        return accountRepo.findById(acctNUm).get();
    }

    @PostMapping("")
    public AccountEntity geAccount(@RequestBody AccountEntity accountEntity){
        return accountRepo.save(accountEntity);
    }
}
