package com.FoodDeliveryApp.Food.delivery.service;

import com.FoodDeliveryApp.Food.delivery.model.Food;
import com.FoodDeliveryApp.Food.delivery.model.OrderModel;
import com.FoodDeliveryApp.Food.delivery.model.UserModel;
import com.FoodDeliveryApp.Food.delivery.repository.IFoodRepo;
import com.FoodDeliveryApp.Food.delivery.repository.IOrderRepo;
import com.FoodDeliveryApp.Food.delivery.repository.IUserRepo;
import com.fasterxml.jackson.databind.util.JSONPObject;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    IOrderRepo iOrderRepo;
    @Autowired
    IUserRepo iUserRepo;
    @Autowired
    IFoodRepo iFoodRepo;

    public List<OrderModel> getall() {
        return iOrderRepo.findAll();
    }

    public ResponseEntity<String> createOrder(String orderrequest) {
        JSONObject errorList = validateOrder(orderrequest);
        if (errorList.length()==0) {
            return new ResponseEntity<>(errorList.toString(), HttpStatus.BAD_REQUEST);
        } else {
            OrderModel order1 = setOrder(orderrequest);
            OrderModel order2 = iOrderRepo.save(order1);
            return new ResponseEntity<>("order created at orderid -  " + order2.getOrderId(), HttpStatus.OK);
        }
    }

    private JSONObject validateOrder(String orderrequest) {
        JSONObject object = new JSONObject(orderrequest);
        JSONObject errorList = new JSONObject();
        if (!object.has("userId")) {
            errorList.put("userId", "missing parameter");
        } else {
            String userId = object.getString("userId");
            UserModel user1 = iUserRepo.findById(Integer.valueOf(userId)).get();
            if (user1 == null) {
                errorList.put("userId", "User by userId does not exists in the database please enter the correct user");
            }
        }
        if (!object.has("foodId")) {
            errorList.put("foodId", "missing parameter");
        } else {
            String foodId = object.getString("foodId");
            Food food1 = iFoodRepo.findById(Integer.valueOf(foodId)).get();
            if (food1 == null) {
                errorList.put("foodId", "Food item does not exists please type another for placing the order");
            }
        }
        return errorList;
    }
    public OrderModel setOrder(String orderrequest){
        JSONObject jsonObject=new JSONObject(orderrequest);
        OrderModel order1=new OrderModel();
        String userId= jsonObject.getString("userId");
        UserModel user1=iUserRepo.findById(Integer.valueOf(userId)).get();
        order1.setUserModel(user1);
        String foodId= jsonObject.getString("foodId");
        Food food1=iFoodRepo.findById(Integer.valueOf(foodId)).get();
        order1.setFood(food1);
        return order1;
    }

    public ResponseEntity<String> getorder(String orderId) {
        List<OrderModel> orders=new ArrayList<>();
        if(orderId==null){
            orders=iOrderRepo.findAll();
        }
        else{
            OrderModel order1=iOrderRepo.findById(Integer.valueOf(orderId)).get();
            orders.add(order1);
        }
        return new ResponseEntity<>(orders.toString(), HttpStatus.OK);
    }
}
