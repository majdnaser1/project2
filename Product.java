package com.example.amazon;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data
public class Product {
    @NotEmpty(message = "id can't be Empty")
    @Size(min = 3,max = 3 ,message = "id must be 3 characters long")
    private int ID;
    @NotEmpty(message = "name can't be Empty")
    @Size(min = 3,max = 3 ,message = "name must be 3 characters long")
    private String name;
    @NotEmpty(message = "price can't be Empty")
    @Positive(message = "price must be positive number")
    private int price;
    @NotEmpty(message = " CategoryID can't be Empty")
    @Size(min = 3,max = 3 ,message = "CategoryID must be 3 characters long")
    private int CategoryID;

    public int getStock() {
    }
}
