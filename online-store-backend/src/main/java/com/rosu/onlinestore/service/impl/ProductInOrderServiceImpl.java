package com.rosu.onlinestore.service.impl;

import com.rosu.onlinestore.model.ProductInOrder;
import com.rosu.onlinestore.model.User;
import com.rosu.onlinestore.repository.ProductInOrderRepository;
import com.rosu.onlinestore.service.ProductInOrderService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.atomic.AtomicReference;

@Service
public class ProductInOrderServiceImpl implements ProductInOrderService {

    @Autowired
    ProductInOrderRepository productInOrderRepository;

    @Override
    @Transactional
    public void update(String itemId, Integer quantity, User user) {
        var op = user.getCart().getProducts().stream().filter(e -> itemId.equals(e.getProductId())).findFirst();
        op.ifPresent(productInOrder -> {
            productInOrder.setCount(quantity);
            productInOrderRepository.save(productInOrder);
        });

    }

    @Override
    public ProductInOrder findOne(String itemId, User user) {
        var op = user.getCart().getProducts().stream().filter(e -> itemId.equals(e.getProductId())).findFirst();
        AtomicReference<ProductInOrder> res = new AtomicReference<>();
        op.ifPresent(res::set);
        return res.get();
    }
}
