package com.ad.oas.controller;

import com.ad.oas.PaymentType;
import com.ad.oas.model.Address;
import com.ad.oas.model.Amount;
import com.ad.oas.model.Payment;
import com.ad.oas.model.Product;
import com.ad.oas.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TeseMVCController {

    @Autowired
    private AddressRepository addressRepository;



    @RequestMapping("/test")
    public @ResponseBody String test(){
        Payment payment = new Payment(
                "12345",
                new Amount(200.0, "CNY"),
                (long)123345,
                0.1538,
                "USD",
                new Amount(120.0 * 6.5, "USD"),
                PaymentType.DEPOSIT);
        Product product = new Product(
                "123456789",
                "Bag",
                2,
                new Amount(10.0, "USD"),
                new Amount(20.0, "USD"),
                new Amount(200.0, "CNY"),
                "8080808080",
                12.0,
                "lbs"
        );
        return "OK";
    }

    public void reposittoryTest(){
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
    }
}
