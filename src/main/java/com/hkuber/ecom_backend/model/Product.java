package com.hkuber.ecom_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity // To get the table in jpa
@Data // Adds getter and setters
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id // makes it a primary key in table
    private int id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;
    private Date releaseDate;
    private int quantity;
    private boolean available;
}
