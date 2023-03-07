package com.example.coffeedee.service.impl;

import com.example.coffeedee.dto.request.OrderDetailRequest;
import com.example.coffeedee.entity.Order;
import com.example.coffeedee.entity.OrderDetails;
import com.example.coffeedee.repository.OrderDetailsRepository;
import com.example.coffeedee.service.OrderDetailService;
import com.example.coffeedee.service.OrderService;
import com.example.coffeedee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderService os;

    @Autowired
    private OrderDetailsRepository odrep;

    @Autowired
    private ProductService ps;

    @Override
    public  List<OrderDetails> addOrderDetails(List<OrderDetailRequest> orderDetailRequests, Long orderId) {
        List<OrderDetails> orderDetails = new ArrayList<>();
        for (OrderDetailRequest odr: orderDetailRequests) {
            OrderDetails od = new OrderDetails();
            Order order = os.getOrderById(orderId);
            od.setOrder(order);
            od.setProduct(ps.findProductById(odr.getProductId()));
            od.setQuantity(odr.getQuantity());
            od.setCreatedBy(Long.valueOf(1));
            orderDetails.add(odrep.save(od));
        }
        return orderDetails;
    }
}
