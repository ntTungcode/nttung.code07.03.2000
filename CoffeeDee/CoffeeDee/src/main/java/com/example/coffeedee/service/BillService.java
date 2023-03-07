package com.example.coffeedee.service;

import com.example.coffeedee.entity.Bill;

public interface BillService {
    Bill addBill(Double taxRate, Long orderId);
}
