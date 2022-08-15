package com.example.amazon;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/stock")
public class merchantStockController {
    private ArrayList<MerchantStock> stocksList =new ArrayList<>();

    @GetMapping("/stock")
    public ResponseEntity getMerchantStock(){
        return ResponseEntity.status(200).body(stocksList);
    }

    @PostMapping("/stock")
    public ResponseEntity addMerchantStock(@RequestBody @Valid MerchantStock stock, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        stocksList.add(stock);
        return ResponseEntity.status(201).body( new ApiResponse("New category added !",201));
    }

    @PutMapping("/stock/{index}")
    public ResponseEntity updateMerchantStock(@RequestBody @Valid MerchantStock stock , @PathVariable int index, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        if(index>=stocksList.size()){
            return ResponseEntity.status(400).body(new ApiResponse("Invalid index",400));
        }
        stocksList.set(index,stock);
        return ResponseEntity.status(201).body( new ApiResponse("category updated !",201));
    }
}
