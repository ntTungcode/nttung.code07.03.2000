package com.example.coffeedee.service.impl;

import com.example.coffeedee.entity.Bill;
import com.example.coffeedee.repository.BillRepository;
import com.example.coffeedee.service.BillService;
import com.example.coffeedee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository br;

    @Autowired
    private OrderService os;

    @Override
    public Bill addBill(Double taxRate, Long orderId) {
        Bill b = new Bill();
        b.setTaxRate(taxRate);
        b.setOrder(os.getOrderById(orderId));
        b.setCreatedBy(Long.valueOf(1));

        return br.save(b);
    }
}
