package com.ad.oas.controller;

import com.ad.oas.model.Address;
import com.ad.oas.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TeseController {

    @Autowired
    private AddressRepository addressRepository;



    @RequestMapping("/test")
    public @ResponseBody String test(){
        addressRepository.save(
                new Address("123",
                        "",
                        "Li",
                        "Ma",
                        "3127098256",
                        "",
                        "",
                        "",
                        "",
                        "12345",
                        "Chengdu",
                        "China"
                ));
        System.out.println(addressRepository.findByZipCode("12345").getPhoneNumber());
        return "OK";
    }
}
