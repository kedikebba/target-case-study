package com.target.assessment.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Data
public class PriceUpdateDTO {

    @NotNull(message = "Price can not be null")
    private Double newPrice;
}
