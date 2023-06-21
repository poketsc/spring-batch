package com.example.springbatch.userOrders;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class OrderStatistics {

    private String amount;
    private LocalDate date;

    @Builder
    public OrderStatistics(String amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }
}
