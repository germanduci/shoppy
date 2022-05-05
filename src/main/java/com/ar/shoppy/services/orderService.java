package com.ar.shoppy.services;

import com.ar.shoppy.models.Orden;
import com.ar.shoppy.repositories.orderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class orderService {

    @Autowired
    private orderRepository orderRepo;

    @Transactional
    public void orderRegister (Orden order){
        orderRepo.save(order);
    }

    public List<Orden> orderListAll(){
        return orderRepo.findAll();
    }

    public Orden orderById(String id){
        Optional<Orden> response = orderRepo.findById(id);
        return response.orElse(null);
    }

    public List<Orden> orderByStatus(String status){
        return orderRepo.findByStatus(status);
    }

    @Transactional
    public void deleteOrder(String id){
        Optional<Orden> response = orderRepo.findById(id);
        response.ifPresent(order -> orderRepo.delete(order));
    }
}
