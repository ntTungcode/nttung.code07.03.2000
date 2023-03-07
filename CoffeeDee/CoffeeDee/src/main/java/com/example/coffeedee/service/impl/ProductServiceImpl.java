package com.example.coffeedee.service.impl;

import com.example.coffeedee.dto.request.ProductRequest;
import com.example.coffeedee.entity.Product;
import com.example.coffeedee.entity.Warehouse;
import com.example.coffeedee.repository.ProductRepository;
import com.example.coffeedee.repository.WarehouseRepository;
import com.example.coffeedee.service.ProductService;
import com.example.coffeedee.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository pr;

    @Autowired
    private WarehouseService ws;

    @Autowired
    private WarehouseRepository wr;

    @Override
    public Product findProductById(Long id) {
        return pr.findProductById(id);
    }

    @Override
    public List<Product> getProductsByCategoryId(Long id) {
        return pr.getProductsByCategoryId(id);
    }

    @Override
    public Product addNewProduct(ProductRequest productReq) {
        Product product = new Product();
        product.setProductName(productReq.getProductName());
        product.setDescription(productReq.getDescription());
        product.setImage(productReq.getImage());
        product.setPrice(productReq.getPrice());
        product.setCreatedBy(Long.valueOf(1));
        Product productAdd = pr.save(product);
        ws.addProductQuantity(productAdd.getId(), productReq.getExpiry(), productReq.getQuantity());
        return productAdd;
    }

    @Override
    public String updateProduct(Long id, ProductRequest productReq) {
        Product product = pr.findProductById(id);
        product.setProductName(productReq.getProductName());
        product.setDescription(productReq.getDescription());
        product.setImage(productReq.getImage());
        product.setPrice(productReq.getPrice());
        product.setUpdatedBy(Long.valueOf(1));
        Warehouse warehouse = wr.getWarehouseByProductId(id);
        warehouse.setExpiry(productReq.getExpiry());
        warehouse.setQuantity(productReq.getQuantity());
        wr.save(warehouse);
        pr.save(product);

        return "Thay đổi thông tin sản phẩm thành công.";
    }

    @Override
    public String deleteProduct(Long id) {
        Product product = pr.findProductById(id);
        product.setDeleted(true);
        product.setUpdatedBy(Long.valueOf(1));
        Warehouse warehouse = ws.getWarehouseByProductId(id);
        warehouse.setDeleted(true);
        warehouse.setUpdatedBy(Long.valueOf(1));
        wr.save(warehouse);
        pr.save(product);

        return "Xóa sản phẩm thành công!";
    }

    @Override
    public List<Product> searchProduct(String searchText) {
        return pr.findProductsByProductNameOrDescription(searchText);
    }
}
