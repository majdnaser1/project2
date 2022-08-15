package com.example.amazon;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class merchantStockService {
    private ArrayList<MerchantStock> stockList = new ArrayList<>();


    public ArrayList<MerchantStock> getMerchantStock() {
        return stockList;
    }

    public void addMerchantStock(MerchantStock stock) {
        stockList.add(stock);
    }

    public void updateMerchantStock(int index, MerchantStock stock) {
        stockList.set(index, stock);
    }

    public void deleteMerchantStock(int index) {
        stockList.remove(index);
    }

    public int addproducttomrchant(int product_id, int merchant_id, int stock ) {
        for (int i = 0; i < stockList.size(); i++) {
//            if (stockList.get(i).getId() == id) {
            if (product_id == merchant_id);

    }
        return stock + 1;}
////                stockList.get(i);
//
//                ArrayList<User> u = new ArrayList<>();
////                if (u.get(i).getRole().equals("admin")) {
////                    Product
//                    int newstock = stockList.get(i).getStock();
//                    return newstock;
//                }

        }


