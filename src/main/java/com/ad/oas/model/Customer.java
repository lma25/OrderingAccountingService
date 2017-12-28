package com.ad.oas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Customer {
    @NonNull
    private String customerId;
    private String wechatId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private List<Address> addresses;
}
