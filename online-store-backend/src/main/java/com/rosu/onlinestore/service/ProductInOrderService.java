package com.rosu.onlinestore.service;


import com.rosu.onlinestore.model.ProductInOrder;
import com.rosu.onlinestore.model.User;

public interface ProductInOrderService {
    void update(String itemId, Integer quantity, User user);
    ProductInOrder findOne(String itemId, User user);
}
