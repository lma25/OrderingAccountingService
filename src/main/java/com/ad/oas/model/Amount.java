package com.ad.oas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Amount {
    private Double value;
    private String currencyCode;
}
