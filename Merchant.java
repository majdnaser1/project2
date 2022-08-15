package com.example.amazon;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@AllArgsConstructor @Data
public class Merchant {
    @NotEmpty(message = "id can't be Empty")
    @Size(min = 3,max = 10 ,message = "id must be 3 characters long")
    private int id;
    @NotEmpty(message = "name can't be Empty")
    @Size(min = 3,max =10 ,message = "name must be 3 characters long")
    private String name;
}
