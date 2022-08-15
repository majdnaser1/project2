package com.example.amazon;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class merchantService {
    private ArrayList<Merchant> merchantsList=new ArrayList<>();


    public ArrayList<Merchant> getMerchant(){
        return merchantsList;
    }

    public void addMerchant(Merchant merchant){
        merchantsList.add(merchant);
    }

    public void updateMerchant(int index, Merchant merchant) {
        merchantsList.set(index,merchant);
    }

    public void deleteMerchant(int index) {
       merchantsList.remove(index);
    }
}
