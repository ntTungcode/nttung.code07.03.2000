package com.example.coffeedee.controller;


import com.example.coffeedee.dto.request.ProductRequest;
import com.example.coffeedee.entity.Product;
import com.example.coffeedee.repository.ProductRepository;
import com.example.coffeedee.service.ProductService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coffee_dee")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    private ProductRepository pr;

    @Autowired
    private ProductService ps;

    @GetMapping("/products")
    public ResponseEntity<?> getProducts() {
        JSONObject response = new JSONObject();
        List<Product> products = pr.getProducts();
        response.put("products", products);
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/product/details/{id}")
    public ResponseEntity<?> getProductById(@PathVariable(value = "id") Long id) {
        JSONObject response = new JSONObject();
        Product product = pr.findProductById(id);
        response.put("product", product);
        return ResponseEntity.ok().body(product);
    }

    @PostMapping("/product/add")
    public ResponseEntity<?> createProduct(@RequestBody ProductRequest productReq) {
        JSONObject response = new JSONObject();
        ps.addNewProduct(productReq);
        response.put("message", "Ok");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/product/update/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable(value = "id") Long id, @RequestBody ProductRequest productReq) {
        JSONObject response = new JSONObject();
        String message = ps.updateProduct(id, productReq);
        response.put("message", message);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Long id) {
        String message = "";
        try {
            ps.deleteProduct(id);
            message = "success";
        } catch (Exception ex) {
            message = "Có lỗi xảy ra trong quá trình xoá sản phẩm";
        }

        JSONObject response = new JSONObject();
        if(!message.trim().equals("success")){
            response.put("message", message);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        message = "Xóa sản phẩm thành công!!";
        response.put("message", message);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/products/search")
    public ResponseEntity<?> searchProduct(@RequestParam("query") String searchText) {
        JSONObject response = new JSONObject();
        List<Product> products = ps.searchProduct(searchText);
        response.put("products", products);
        return ResponseEntity.ok().body(products);
    }

}
