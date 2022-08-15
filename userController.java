package com.example.amazon;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/user")
public class userController {
    private ArrayList<User> usersList=new ArrayList<>();
    Product product;
    productService productservice;


    @GetMapping("/users")
    public ResponseEntity getUser(){
        return ResponseEntity.status(200).body(usersList);
    }

    @PostMapping("/register")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        usersList.add(user);
        return ResponseEntity.status(201).body( new ApiResponse("New user added !",201));
    }

    @PutMapping("/users/{index}")
    public ResponseEntity updateUser(@RequestBody @Valid User user,@PathVariable int index,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        if(index>=usersList.size()){
            return ResponseEntity.status(400).body(new ApiResponse("Invalid index",400));
        }
        usersList.set(index,user);
        return ResponseEntity.status(201).body( new ApiResponse("User updated !",201));
    }

    @DeleteMapping("/users/{index}")
    public ResponseEntity deleteUser(@PathVariable int index){
        if(index>=usersList.size()){
            return ResponseEntity.status(400).body(new ApiResponse("Invalid index",400));
        }
        usersList.remove(index);
        return ResponseEntity.status(200).body(new ApiResponse("User deleted !",200));
    }
    @PostMapping("/buy")
    public ResponseEntity<String> purchaseCar(@RequestParam String userid,@RequestParam String carid){
        Integer productcase=productService.purchaseProdect(userid,carid);
        switch (productcase){
            case -1:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User id or card id is wrong");
            case 0:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You don't have enough money for the car");
            case 1:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There is no product available to buy");
            case 2:
                return ResponseEntity.status(HttpStatus.OK).body("product purchased !");
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server error !");
        }


//    @PostMapping("/login")
//    public ResponseEntity login(@RequestBody @Valid LoginForm loginForm,Errors errors){
//        if(errors.hasErrors()){
//            String message=errors.getFieldError().getDefaultMessage();
//            return ResponseEntity.status(400).body(new ApiResponse(message,400));
//        }
//
//        for (int i = 0; i < usersList.size(); i++) {
//            User user=usersList.get(i);
//            if(user.getUsername().equals(loginForm.getUsername())&&
//                    user.getPassword().equals(loginForm.getPassword())){
//                return ResponseEntity.status(200).body(new ApiResponse("Welcome back",200));
//            }
//        }
//
//        return ResponseEntity.status(400).body(new ApiResponse("Wrong username or password",400));

    }






