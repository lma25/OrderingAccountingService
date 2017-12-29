package com.ad.oas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    private String customerId;
    private String wechatId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private List<Address> addresses = Arrays.asList(new Address());
}
