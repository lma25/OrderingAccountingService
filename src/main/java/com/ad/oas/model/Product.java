package com.ad.oas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Product {
    private String barCode;
    private String productName;
    private Integer quantity;
    private Amount unitPrice;
    private Amount totalPurchaseAmount;
    private Amount totalSellAmount;
    private String purchaseTrackingNumber;
    private Double weight;
    private String weightUnit;
}
