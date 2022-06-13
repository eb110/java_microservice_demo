package com.wfigura.os.api.common;

import com.wfigura.os.api.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {

    private Order order;
    private String transactionId;
    private double amount;
    private String message;
}
