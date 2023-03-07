package com.example.coffeedee.service.impl;

import com.example.coffeedee.dto.request.WarehouseRequest;
import com.example.coffeedee.entity.Product;
import com.example.coffeedee.entity.Warehouse;
import com.example.coffeedee.repository.ProductRepository;
import com.example.coffeedee.repository.WarehouseRepository;
import com.example.coffeedee.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseRepository wr;

    @Autowired
    private ProductRepository pr;

    @Override
    public Warehouse addProductQuantity(Long id, String expiry, Long quantity) {
        Warehouse warehouse = new Warehouse();
        Product product = pr.findProductById(id);
        warehouse.setExpiry(expiry);
        warehouse.setQuantity(quantity);
        warehouse.setProduct(product);
        warehouse.setCreatedBy(Long.valueOf(1));
        wr.save(warehouse);
        return warehouse;
    }

    @Override
    public Warehouse getWarehouseByProductId(Long id) {
        return wr.getWarehouseByProductId(id);
    }

    @Override
    public List<Warehouse> getWarehouses() {
        return wr.getWarehouses();
    }

    @Override
    public String updateProductInWarehouse(Long productId, WarehouseRequest warehouseReq) {
        Warehouse warehouse = wr.getWarehouseByProductId(productId);
        warehouse.setExpiry(warehouseReq.getExpiry());
        warehouse.setQuantity(warehouseReq.getQuantity());
        warehouse.setCreatedBy(Long.valueOf(1));
        wr.save(warehouse);
        return "Thay đổi thông tin thành công.";
    }

    @Override
    public String deleteProductInWarehouse(Long productId) {
        Warehouse warehouse = wr.getWarehouseByProductId(productId);
        Product product = pr.findProductById(warehouse.getProduct().getId());
        product.setDeleted(true);
        warehouse.setDeleted(true);
        pr.save(product);
        wr.save(warehouse);
        return "Xóa sản phẩm trong kho thành công.";
    }
}
