package com.ad.oas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NextIndex {
    @NonNull
    @Id
    private Long id;
    private Long nextCustomerId;
    private Long nextAddressId;
    private Long nextOrderId;
    private Long nextShipmentId;
}
