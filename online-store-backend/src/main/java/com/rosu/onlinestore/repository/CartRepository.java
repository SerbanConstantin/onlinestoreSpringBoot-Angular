package com.rosu.onlinestore.repository;

import com.rosu.onlinestore.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
