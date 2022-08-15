package com.example.amazon;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1/merchant")
public class merchantController {
    private ArrayList<Merchant> merchantsList =new ArrayList<>();

    @GetMapping("/merchant")
    public ResponseEntity getMerchants(){
        return ResponseEntity.status(200).body(merchantsList);
    }

    @PostMapping("/merchant")
    public ResponseEntity addMerchant(@RequestBody @Valid Merchant merchant, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        merchantsList.add(merchant);
        return ResponseEntity.status(201).body( new ApiResponse("New category added !",201));
    }

    @PutMapping("/merchant/{index}")
    public ResponseEntity updateUser(@RequestBody @Valid Merchant merchant , @PathVariable int index, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        if(index>=merchantsList.size()){
            return ResponseEntity.status(400).body(new ApiResponse("Invalid index",400));
        }
        merchantsList.set(index,merchant);
        return ResponseEntity.status(201).body( new ApiResponse("category updated !",201));
    }
}
