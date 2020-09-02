package com.target.assessment.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Data
public class PriceUpdateDTO {

    @NotEmpty
    private Double newPrice;
}
