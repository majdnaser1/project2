package com.example.amazon;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class usersService {

        private ArrayList<User> usersList=new ArrayList<>();
        Product product;
        MerchantStock merchantStock;



        public ArrayList<User> getUsers(){
            return usersList;
        }

        public void addUser(User user){
            usersList.add(user);
        }

        public void updateUser(int index, User user) {
            usersList.set(index,user);
        }

        public void deleteUser(int index) {
            usersList.remove(index);
        }


        }
    public static Integer purchaseProdect(String userid, String carid) {
            Product product=getUsers(userid);
            User user=productList.(carid);

            if(userid==null || carid ==null){
                return -1;
            }

            if(user.getBalance()<product.getPrice()){
                return 0;
            }

            if(product.getStock()==0){
                return 1;
            }

            Integer oldStock=product.getStock();
            merchantStock.setStock(oldStock-1);

            Integer oldBalance=user.getBalance();
            user.setBalance(oldBalance-product.getPrice());

            return 2;

        }


//        public boolean login(LoginForm loginForm) {
//            for (int i =0; i < usersList.size(); i++) {
//                User user=usersList.get(i);
//                if(user.getUsername().equals(loginForm.getUsername())&&
//                        user.getPassword().equals(loginForm.getPassword())){
//                    return true;
//                }
//            }
//            return false;
//        }false
    }
}
