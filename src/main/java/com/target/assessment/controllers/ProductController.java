package com.target.assessment.controllers;

import com.target.assessment.model.PriceUpdateDTO;
import com.target.assessment.model.ProductDetails;
import com.target.assessment.model.ProductPrice;
import com.target.assessment.service.IProductService;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Validated
@RestController
@RequestMapping("/products")
public class ProductController {

    private IProductService iProductService;
    public ProductController(IProductService iProductService){
        this.iProductService = iProductService;
    }

    @GetMapping(value = "/{id}",produces = "application/json")
    public ProductDetails getProduct( @PathVariable(value = "id")  @Size(min = 8,max = 8,message = "Input should be of length - 8") String id) throws Exception {
        return iProductService.getProductDetails(Integer.parseInt(id));
    }
    @GetMapping(value = "/saveAll",produces = "application/json")
    public void saveData(){
         iProductService.saveAllProductPrices();
    }

    @PutMapping(value = "/{id}",produces = "application/json")
    public ResponseEntity<ProductPrice> updateProductPrice( @PathVariable(value = "id")
                                                               @Size(max = 8, min = 8, message = "Input should be of length - 8") String id,
                                                           @Valid @RequestBody PriceUpdateDTO priceUpdateDTO ) throws Exception {
        return new ResponseEntity<ProductPrice>(iProductService.updateProductPrice(Integer.parseInt(id), priceUpdateDTO), HttpStatus.ACCEPTED);
    }

}
