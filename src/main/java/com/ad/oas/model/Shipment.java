package com.ad.oas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class Shipment {
    @NonNull
    private String shipmentId;
    @NonNull
    private List<String> orderId;
    @NonNull
    private List<String> customerId;
    @NonNull
    private String trackingNumber;
    @NonNull
    private String carrier;
    @NonNull
    private Date shippingDate;
    @NonNull
    private Amount shippingCost;
    @NonNull
    private List<CustomerProduct> customerProducts;

}
