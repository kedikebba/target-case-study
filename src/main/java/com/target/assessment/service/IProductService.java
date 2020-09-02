package com.target.assessment.service;

import com.target.assessment.model.PriceUpdateDTO;
import com.target.assessment.model.ProductDetails;
import com.target.assessment.model.ProductPrice;
import org.json.JSONException;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    public ProductPrice saveProductPrice(ProductPrice productPrice);
    public ProductPrice getProductPriceByProductID(Integer productID);
    public void saveAllProductPrices();
    public ProductPrice updateProductPrice(Integer productID, PriceUpdateDTO priceUpdateDTO);

    public ProductDetails getProductDetails(Integer productID) throws JSONException;
}
