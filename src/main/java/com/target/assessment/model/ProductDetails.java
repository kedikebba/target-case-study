package com.target.assessment.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;

@NoArgsConstructor
@Data
public class ProductDetails {
    private Integer productID;
    private String productName;
    private ProductPrice productPrice;
}
