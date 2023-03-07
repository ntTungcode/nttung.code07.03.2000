package com.example.coffeedee.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

    private Double totalPrice;
    private String note;
    private String employeeNote;
    private Double taxRate;
    private List<OrderDetailRequest> orderDetails;
}
