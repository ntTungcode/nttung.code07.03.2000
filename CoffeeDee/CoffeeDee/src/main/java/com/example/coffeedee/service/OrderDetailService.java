package com.example.coffeedee.service;

import com.example.coffeedee.dto.request.OrderDetailRequest;
import com.example.coffeedee.entity.OrderDetails;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetails> addOrderDetails(List<OrderDetailRequest> orderDetailRequests, Long orderId);
}
