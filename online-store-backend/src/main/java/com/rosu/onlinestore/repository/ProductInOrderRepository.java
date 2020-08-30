package com.rosu.onlinestore.repository;

import com.rosu.onlinestore.model.ProductInOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInOrderRepository extends JpaRepository<ProductInOrder, Long> {

}
