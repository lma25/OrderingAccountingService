package com.ad.oas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class CustomerProduct {
    @NonNull
    private String customerId;
    @NonNull
    private Product product;
}
