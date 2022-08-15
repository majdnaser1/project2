package com.example.amazon;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
@RequiredArgsConstructor
public class productService {


    private ArrayList<Product> productList=new ArrayList<>();
    private final User user;
    private final Merchant merchant;
    private final Product product;
    private final MerchantStock merchantStock;




    public ArrayList<Product> getUsers(){
        return productList;
    }

    public void addUser(Product product){
        productList.add(product);
    }

    public void updateUser(int index, Product product) {
        productList.set(index,product);
    }

    public void deleteUser(int index) {
        productList.remove(index);
    }



}

