package com.example.coffeedee.controller;

import com.example.coffeedee.dto.request.WarehouseRequest;
import com.example.coffeedee.dto.response.WarehouseResponse;
import com.example.coffeedee.entity.Product;
import com.example.coffeedee.entity.Warehouse;
import com.example.coffeedee.service.ProductService;
import com.example.coffeedee.service.WarehouseService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/coffee_dee")
@CrossOrigin(origins = "http://localhost:4200")
public class WarehouseController {

    @Autowired
    private WarehouseService ws;

    @Autowired
    private ProductService ps;

    @GetMapping("/warehouses")
    public ResponseEntity<?> getWarehouses() {
        List<Warehouse> warehouses = ws.getWarehouses();
        List<WarehouseResponse> warehouseResponses = new ArrayList<>();

        for (Warehouse w: warehouses) {
            WarehouseResponse warehouseResponse = new
                    WarehouseResponse(w.getId(), w.getProduct().getId(), w.getProduct().getProductName(), w.getExpiry(), w.getQuantity());
            warehouseResponses.add(warehouseResponse);
        }

        return ResponseEntity.ok().body(warehouseResponses);
    }

    @GetMapping("/warehouse/{id}")
    public ResponseEntity<?> getWarehouseByProductId(@PathVariable(value = "id") Long id) {
        Warehouse warehouse = ws.getWarehouseByProductId(id);
        Product product = ps.findProductById(warehouse.getProduct().getId());
        WarehouseResponse warehouseResponse = new WarehouseResponse();
        warehouseResponse.setId(warehouse.getId());
        warehouseResponse.setProductId(id);
        warehouseResponse.setProductName(product.getProductName());
        warehouseResponse.setExpiry(warehouse.getExpiry());
        warehouseResponse.setQuantity(warehouse.getQuantity());
        return ResponseEntity.ok().body(warehouseResponse);
    }

    @PutMapping("/warehouse/product/update/{id}")
    public ResponseEntity<?> updateProductInfo(@PathVariable(value = "product_id") Long productId, @RequestBody WarehouseRequest warehouseReq) {
        JSONObject response = new JSONObject();
        String message = ws.updateProductInWarehouse(productId, warehouseReq);
        response.put("message", message);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/warehouse/product/delete/{id}")
    public ResponseEntity<?> deleteProductInfo(@PathVariable(value = "product_id") Long productId) {
        JSONObject response = new JSONObject();
        String message = ws.deleteProductInWarehouse(productId);
        response.put("message", message);
        return ResponseEntity.ok(response);
    }

}

