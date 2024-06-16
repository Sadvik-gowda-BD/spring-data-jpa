package com.bank.springdatajpa.controller;


import com.bank.springdatajpa.entity.AddressEntity;
import com.bank.springdatajpa.repo.AddressRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressRepo addressRepo;

    @PostMapping("/load")
    public boolean loadData() {
        String state = "KAR-";
        String country = "CNT-";
        for (int i = 1; i <= 15; i++) {
            AddressEntity address = AddressEntity.builder()
                    .state(state + i)
                    .country(country + i)
                    .build();
            addressRepo.save(address);
        }
        return true;
    }

    @GetMapping("/pages")
    public List<AddressEntity> getByPage(@RequestParam("page") int page, @RequestParam("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        //Pagination with sorting
        //PageRequest.of(page, size, Sort.by("addressId").descending());
        Page<AddressEntity> response = addressRepo.findAll(pageable);
        return response.getContent();
    }
}
