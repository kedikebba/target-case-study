package com.target.assessment.controllers;

import com.target.assessment.model.PriceUpdateDTO;
import com.target.assessment.model.ProductDetails;
import com.target.assessment.model.ProductPrice;
import com.target.assessment.service.IProductService;
import org.json.JSONException;
import org.mockito.Mockito;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ProductController.class})
class ProductControllerTest {

    @MockBean
    IProductService iProductService;

    @Test
    void getProduct() throws JSONException {

        ProductPrice productPrice = new ProductPrice();
        productPrice.setId(1l);
        productPrice.setProductID(13860428);
        productPrice.setValue(123.4);
        productPrice.setCurrency_code("USD");

        ProductDetails productDetails = new ProductDetails();
        productDetails.setProductID(13860428);
        productDetails.setProductName("The Big Lebowski (Blu-ray)");
        productDetails.setProductPrice(productPrice);

        Mockito.when(iProductService.getProductDetails(13860428)).thenReturn(productDetails);
        ProductDetails productDetailsTest = iProductService.getProductDetails(13860428);
        Mockito.verify(iProductService, Mockito.times(1)).getProductDetails(13860428);

        assertEquals(productDetailsTest, productDetails);

    }

    @Test
    void updateProductPrice() throws JSONException {

        ProductPrice productPrice = new ProductPrice();
        productPrice.setId(1l);
        productPrice.setProductID(13860428);
        productPrice.setValue(128.4);
        productPrice.setCurrency_code("USD");

        PriceUpdateDTO priceUpdateDTO = new PriceUpdateDTO();
        priceUpdateDTO.setNewPrice(128.4);

        Mockito.when(iProductService.updateProductPrice(13860428,priceUpdateDTO)).thenReturn(productPrice);
        ProductPrice productPriceTest = iProductService.updateProductPrice(13860428,priceUpdateDTO);
        Mockito.verify(iProductService, Mockito.times(1)).updateProductPrice(13860428,priceUpdateDTO);

        assertEquals(productPriceTest, productPrice);
    }
}