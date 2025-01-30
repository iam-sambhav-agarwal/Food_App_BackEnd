package com.sam.Service;

import com.sam.model.Order;
import com.sam.model.User;
import com.sam.request.OrderRequest;

import java.util.List;

public interface OrderService {

    public Order createOrder(OrderRequest order, User user) throws Exception;

    public Order updateOrder(Long orderId, String orderStatus) throws Exception;

    void cancelOrder(Long orderId) throws Exception;

    List<Order> getUserOrder(Long userId) throws Exception;

    List<Order> getRestaurantOrder(Long restaurantId, String orderStatus) throws Exception;

    public Order findOrderById(Long orderId) throws Exception;


}
