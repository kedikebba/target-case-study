package com.target.assessment.repository;


import com.target.assessment.model.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductPrice, Long> {
    public Optional<ProductPrice> findProductPriceByProductID(Integer productID);

}
