package com.sam.repository;

import com.sam.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {


    public Cart findByCustomerId(Long userId);

}
