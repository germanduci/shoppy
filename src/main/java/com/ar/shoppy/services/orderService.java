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

    public void registerOrder (Order order){
        orderRepo.save(order);
    }

    public List<Order> orderList(){
        return orderRepo.findAll();
    }

    public Order orderListId(String id){
        Optional<Order> response = orderRepo.findById(id);
        if (response.isPresent()){
            Order order = response.get();
            return order;
        }else{
            return null;
        }
    }

    public Order orderListClient(String name){
        Optional<Order>response = orderRepo.findByClient(name);
        if (response.isEmpty()){
            Order order = response.get();
            return order;
        }else{
            return null;
        }
    }

    public void deleteOrder(String id){
        Optional<Order> response = orderRepo.findById(id);
        if (response.isPresent()){
            orderRepo.delete(response.get());
        }
    }

    //Verificar modificación de estado de ordenes segun cliente.
    public List<Order> orderStatus(String status){
         return orderRepo.findByStatus(status);
    }
}
