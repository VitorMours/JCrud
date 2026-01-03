package com.backend.jcrud.services;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.jcrud.repositories.OrderRepository;

import com.backend.jcrud.models.Order;

@Service 
public class OrderService {
    
    @Autowired 
    private OrderRepository orderRepository;

    public Order createOrder(Order orderData){
        Order newOrder = orderRepository.save(orderData);
        return newOrder;
    }

    public List<Order> getAllOrders(){
        List<Order> orders = orderRepository.findAll();
        return orders;
    }

    public Order getOrderById(Long id){
        Order order = orderRepository.findById(id).orElse(null);
        return order;
    }
    public Order updateOrder(Long id, Order newOrderData){
        Order order = orderRepository.findById(id).orElse(null);

        if(order.equals(null)){

            // TODO: Need to thrrow an error
        }

        order.setClient(newOrderData.getClient());
        order.setMoment(newOrderData.getMoment());
        orderRepository.save(order);
        return order;
    }

}
