package com.hkuber.ecom_backend.controller;

import com.hkuber.ecom_backend.model.Product;
import com.hkuber.ecom_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/home")
    public String greet() {
        return "Hello world";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.FOUND);
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable int id) {
        return productService.getProduct(id);
    }

    @GetMapping("/products/{id}/image")
    public ResponseEntity<byte[]> getProductImage(@PathVariable int id) {
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(productService.getProduct(id).getImageType()))
                .body(productService.getProduct(id).getImageData());
    }

    @PostMapping("/products")
    public ResponseEntity<Void> postProduct(@RequestPart Product product, @RequestPart MultipartFile multipartFile) throws IOException {
        HttpStatus status = productService.postProduct(product, multipartFile) != null ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(status);
    }
}
