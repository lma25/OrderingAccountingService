package com.ad.oas.model;

import com.ad.oas.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Payment {
    @NonNull
    private String moneyTransferScreenshotId;
    @NonNull
    private Amount localAmount;
    @NonNull
    private Long transferDate;
    private Double localToFunctionalFxRate;
    private String functionalAmountCurrency;
    private Amount functionalAmount;
    private PaymentType paymentType;
}
