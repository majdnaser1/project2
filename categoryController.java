package com.example.amazon;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1/category")
public class categoryController {
    private ArrayList<Category> categoryList =new ArrayList<>();

    @GetMapping("/category")
    public ResponseEntity getUser(){
        return ResponseEntity.status(200).body(categoryList);
    }

    @PostMapping("/category")
    public ResponseEntity addUser(@RequestBody @Valid Category category, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        categoryList.add(category);
        return ResponseEntity.status(201).body( new ApiResponse("New category added !",201));
    }

    @PutMapping("/category/{index}")
    public ResponseEntity updateUser(@RequestBody @Valid Category category , @PathVariable int index, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        if(index>=categoryList.size()){
            return ResponseEntity.status(400).body(new ApiResponse("Invalid index",400));
        }
        categoryList.set(index,category);
        return ResponseEntity.status(201).body( new ApiResponse("category updated !",201));
    }

    @DeleteMapping("/category/{index}")
    public ResponseEntity deleteUser(@PathVariable int index){
        if(index>=categoryList.size()){
            return ResponseEntity.status(400).body(new ApiResponse("Invalid index",400));
        }
        categoryList.remove(index);
        return ResponseEntity.status(200).body(new ApiResponse("User deleted !",200));
    }
}
