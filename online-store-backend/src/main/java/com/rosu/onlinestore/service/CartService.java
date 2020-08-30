package com.rosu.onlinestore.service;


import com.rosu.onlinestore.model.Cart;
import com.rosu.onlinestore.model.ProductInOrder;
import com.rosu.onlinestore.model.User;

import java.util.Collection;

public interface CartService {
    Cart getCart(User user);

    void mergeLocalCart(Collection<ProductInOrder> productInOrders, User user);

    void delete(String itemId, User user);

    void checkout(User user);
}
