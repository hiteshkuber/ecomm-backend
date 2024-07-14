package com.hkuber.ecom_backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.math.BigDecimal;
import java.util.Date;

@Entity // To get the table in jpa
@Data // Adds getter and setters
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id // makes it a primary key in table
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date releaseDate;
    private int quantity;
    private boolean available;

    private String imageName;
    private String imageType;

    @Lob
    private byte[] imageData;
}
