package com.example.coffeedee.service;

import com.example.coffeedee.dto.request.OrderRequest;
import com.example.coffeedee.entity.Order;

public interface OrderService {

    Order addOrder(OrderRequest orderRequest);

    Order getOrderById(Long id);
}
