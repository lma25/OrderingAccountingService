package com.ad.oas.controller;

import com.ad.oas.PaymentType;
import com.ad.oas.model.Amount;
import com.ad.oas.model.Payment;
import com.ad.oas.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping("/json")
    public @ResponseBody
    String json(){
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
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(payment);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(json);
        return "OK";
    }
}
