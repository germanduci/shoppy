package com.ar.shoppy.services;

import com.ar.shoppy.domain.Order;
import com.ar.shoppy.repository.orderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class orderService {

    @Autowired
    private orderRepository orderRepo;

    public void orderRegister (Order order){
        orderRepo.save(order);
    }

    public List<Order> orderAll(){
        return orderRepo.findAll();
    }

    public Order orderById(String id){
        Optional<Order> response = orderRepo.findById(id);
        return response.orElse(null);
    }

    public Order orderByClient(String name){
        Optional<Order>response = orderRepo.findByClient(name);
        return response.orElse(null);
    }

    public void deleteOrder(String id){
        Optional<Order> response = orderRepo.findById(id);
        response.ifPresent(order -> orderRepo.delete(order));
    }

    public List<Order> orderByStatus(String status){
        return orderRepo.findByStatus(status);
    }
}
