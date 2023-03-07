package com.example.coffeedee.service.impl;

import com.example.coffeedee.dto.request.OrderRequest;
import com.example.coffeedee.entity.Order;
import com.example.coffeedee.repository.CustomerRepository;
import com.example.coffeedee.repository.EmployeeRepository;
import com.example.coffeedee.repository.OrderRepository;
import com.example.coffeedee.service.OrderDetailService;
import com.example.coffeedee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EmployeeRepository er;

    @Autowired
    private CustomerRepository cr;

    @Autowired
    private OrderDetailService ods;

    @Override
    public Order addOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setTotalPrice(orderRequest.getTotalPrice());
        order.setNote(orderRequest.getNote());
        order.setEmployeeNote(orderRequest.getEmployeeNote());
        order.setIsCompleted(false);
        order.setCustomer(cr.getCustomerById(Long.valueOf(1)));
        order.setEmployee(er.getEmployeeById(Long.valueOf(1)));
        order.setCreatedBy(Long.valueOf(1));
        try {
        Order orderAdded = orderRepository.save(order);
        ods.addOrderDetails(orderRequest.getOrderDetails(), orderAdded.getId());
        return orderAdded;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.getOrderById(id);
    }
}
