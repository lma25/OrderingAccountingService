package com.ad.oas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@Setter
@Getter
public class Address {
    @NonNull
    @Id
    private String addressId;
    @NonNull
    private String customerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String zipCode;
    private String stateOrProvince;
    private String country;
}
