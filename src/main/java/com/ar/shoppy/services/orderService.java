package com.ar.shoppy.services;

import com.ar.shoppy.domain.order;
import com.ar.shoppy.repository.orderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class orderService {

    @Autowired
    private orderRepository orderRepo;

    public void orderRegister (order order){orderRepo.save(order);}

    public List<order> orderAll(){return orderRepo.findAll();}

    public order orderById(String id){
        Optional<order> response = orderRepo.findById(id);
        if (response.isPresent()){
            order order = response.get();
            return order;
        }else{
            return null;
        }
    }

    public order orderByClient(String name){
        Optional<order>response = orderRepo.findByClient(name);
        if (response.isEmpty()){
            order order = response.get();
            return order;
        }else{
            return null;
        }
    }

    public void deleteOrder(String id){
        Optional<order> response = orderRepo.findById(id);
        if (response.isPresent()){
            orderRepo.delete(response.get());
        }
    }

    //Verificar modificación de estado de ordenes segun cliente.
    public List<order> orderByStatus(String status){
         return orderRepo.findByStatus(status);
    }
}
