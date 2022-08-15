package com.example.amazon;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1/product")
public class productController {
    private ArrayList<Product> productList=new ArrayList<>();
    private final productService productservice;

    public productController(productService productservice) {
        this.productservice = productservice;
    }

    @GetMapping("/product")
    public ResponseEntity getProduct(){
        return ResponseEntity.status(200).body(productList);
    }

    @PostMapping("/product")
    public ResponseEntity addProduct(@RequestBody @Valid Product product, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        productList.add(product);
        return ResponseEntity.status(201).body( new ApiResponse("New user added !",201));
    }

    @PutMapping("/users/{index}")
    public ResponseEntity updateProduct(@RequestBody @Valid Product product, @PathVariable int index, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        if(index>=productList.size()){
            return ResponseEntity.status(400).body(new ApiResponse("Invalid index",400));
        }
        productList.set(index,product);
        return ResponseEntity.status(201).body( new ApiResponse("User updated !",201));
    }

    @DeleteMapping("/users/{index}")
    public ResponseEntity deleteProduct(@PathVariable int index){
        if(index>=productList.size()){
            return ResponseEntity.status(400).body(new ApiResponse("Invalid index",400));
        }
        productList.remove(index);
        return ResponseEntity.status(200).body(new ApiResponse("User deleted !",200));
    }
}
