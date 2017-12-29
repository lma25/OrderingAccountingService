package com.ad.oas.controller;

import com.ad.oas.exception.DataParsingException;
import com.ad.oas.model.Customer;
import com.ad.oas.model.Result;
import com.ad.oas.repository.CustomerRepository;
import com.ad.oas.util.ResultUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;

@Controller
public class UserController {

    @Resource(name="objectMapper")
    private ObjectMapper objectMapper;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ResultUtils resultUtils;

    @RequestMapping(
            value = "/customerSignUp",
            method = RequestMethod.POST
    )
    public @ResponseBody String customerSignUp(@NonNull final String customerJson){
        final Result result = new Result("customerSignUp", true);
        try {
            final Customer customer = parseJsonToCustomer(customerJson);
            customerRepository.save(customer);
            result.setReturnMessage(customerJson);
        } catch(Exception e) {
            result.appendErrorMessage(e.getMessage());
        } finally {
            return resultUtils.resultToString(result);
        }
    }

    @RequestMapping(value = "/getCustomerStruct")
    public @ResponseBody String getCustomerStruct(){
        final Result result = new Result("getCustomerStruct", true);
        try {
            result.setReturnMessage(objectMapper.writeValueAsString(new Customer()));
        } catch (JsonProcessingException e) {
            result.appendErrorMessage(e.getMessage());
        } finally {
            return resultUtils.resultToString(result);
        }
    }

    private Customer parseJsonToCustomer(@NonNull final String customerJson){
        Customer customer;
        try {
            customer = objectMapper.readValue(customerJson, Customer.class);
        } catch (IOException e) {
            throw new DataParsingException("customerJson cannot convert to Customer. customerJson:"+ customerJson);
        }
        return customer;
    }

}
