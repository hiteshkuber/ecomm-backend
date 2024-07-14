package com.hkuber.ecom_backend.service;

import com.hkuber.ecom_backend.model.Product;
import com.hkuber.ecom_backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Component
@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(int id) {
        return productRepository.findById(id).orElse(new Product());
    }

    public Product postProduct(Product product, MultipartFile multipartFile) throws IOException {

        product.setImageName(multipartFile.getOriginalFilename());
        product.setImageType(multipartFile.getContentType());
        product.setImageData(multipartFile.getBytes());
        return productRepository.save(product);
    }
}
