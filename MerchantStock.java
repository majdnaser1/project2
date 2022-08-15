package com.example.amazon;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data
public class MerchantStock {
    @NotEmpty(message = "id can't be Empty")
    @Size(min = 3,max = 3 ,message = "id must be 3 characters long")
    private int id;
    @NotEmpty(message = "id can't be Empty")
    @Size(min = 3,max = 3 ,message = "id must be 3 characters long")
    private int product_id;
    @NotEmpty(message = "id can't be Empty")
    @Size(min = 3,max = 3 ,message = "id must be 3 characters long")
    private int merchant_id;
    @NotEmpty(message = "stock can't be Empty")
    @Size(min = 10,max = 200 ,message = "stock must be more than 10 at start ")
    private int stock;


}
