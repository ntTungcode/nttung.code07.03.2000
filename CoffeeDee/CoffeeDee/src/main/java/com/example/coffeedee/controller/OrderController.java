package com.example.coffeedee.controller;

import com.example.coffeedee.dto.request.OrderRequest;
import com.example.coffeedee.entity.Bill;
import com.example.coffeedee.entity.Order;
import com.example.coffeedee.service.BillService;
import com.example.coffeedee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coffee_dee")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
    @Autowired
    private OrderService os;

    @Autowired
    private BillService bs;

    @PostMapping("/order/add")
    public ResponseEntity<?> addOrder(@RequestBody OrderRequest orderRequest) {
        Order order = os.addOrder(orderRequest);
        Bill bill = bs.addBill(orderRequest.getTaxRate(), order.getId());
        return ResponseEntity.ok().body(order);
    }
}
