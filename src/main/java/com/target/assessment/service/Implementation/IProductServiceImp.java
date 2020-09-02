package com.target.assessment.service.Implementation;


import com.target.assessment.config.ConfigProperties;
import com.target.assessment.model.PriceUpdateDTO;
import com.target.assessment.model.ProductDetails;
import com.target.assessment.model.ProductPrice;
import com.target.assessment.repository.ProductRepository;
import com.target.assessment.service.IProductService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.DecimalFormat;
import java.util.Optional;
import java.util.Random;

@Service
public class IProductServiceImp implements IProductService {

    private ProductRepository productRepository;
    private RestTemplate restTemplate;
    private final ConfigProperties configProperties;

    public IProductServiceImp(ProductRepository productRepository, RestTemplate restTemplate, ConfigProperties configProperties){
        this.productRepository = productRepository;
        this.restTemplate = restTemplate;
        this.configProperties = configProperties;
    }

    @Override
    public void saveAllProductPrices() {


        Random r = new Random();
        DecimalFormat df = new DecimalFormat("#.##");


        for(int i = 13860428; i<13861428; i++){
            ProductPrice productPrice = new ProductPrice();
            double price = 5 + (1000 - 5) * r.nextDouble();
            price = Double.valueOf(df.format(price));
            productPrice.setProductID(i);
            productPrice.setCurrency_code("USD");
            productPrice.setValue(price);
            System.out.println(productRepository.save(productPrice));

        }

    }

    @Override
    public ProductPrice updateProductPrice(Integer productID, PriceUpdateDTO priceUpdateDTO) {

        if(productRepository.findProductPriceByProductID(productID).isPresent()){
            ProductPrice productPrice = productRepository.findProductPriceByProductID(productID).get();
            productPrice.setValue(priceUpdateDTO.getNewPrice());
            return productRepository.save(productPrice);
        }else return null;
    }

    @Override
    public ProductDetails getProductDetails(Integer productID) throws JSONException {

        String url = this.configProperties.getUrl();
        String path = this.configProperties.getPath();
        String res = restTemplate.getForObject(url+productID+path, String.class);
        ProductDetails productDetails = new ProductDetails();

        JSONObject jsonObject = new JSONObject(res);

        jsonObject = jsonObject.getJSONObject("product").getJSONObject("item").getJSONObject("product_description");
        String productName = (String)jsonObject.get("title");

        ProductPrice productPrice = productRepository.findProductPriceByProductID(productID).get();

        productDetails.setProductID(productID);
        productDetails.setProductName(productName);
        productDetails.setProductPrice(productPrice);

        return productDetails;
    }

    @Override
    public ProductPrice saveProductPrice(ProductPrice productPrice) {
        return productRepository.save(productPrice);
    }

    @Override
    public ProductPrice getProductPriceByProductID(Integer productID) {
        return productRepository.findProductPriceByProductID(productID).orElse(null);
    }
}
