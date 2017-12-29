package com.ad.oas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class Order {
    @NonNull
    @Id
    private String orderId;
    @NonNull
    private String customerId;
    @NonNull
    private String wechatId;
    @NonNull
    private List<Product> products;
    private List<Shipment> shipments;
    private List<Payment> payments;
}
