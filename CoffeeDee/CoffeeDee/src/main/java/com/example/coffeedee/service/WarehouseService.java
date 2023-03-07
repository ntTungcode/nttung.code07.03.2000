package com.example.coffeedee.service;

import com.example.coffeedee.dto.request.WarehouseRequest;
import com.example.coffeedee.entity.Warehouse;

import java.util.List;

public interface WarehouseService {
    Warehouse addProductQuantity(Long id, String expiry, Long quantity);

    Warehouse getWarehouseByProductId(Long id);

    List<Warehouse> getWarehouses();

    String updateProductInWarehouse(Long productId, WarehouseRequest warehouseReq);

    String deleteProductInWarehouse(Long productId);
}
