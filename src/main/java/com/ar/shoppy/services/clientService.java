package com.ar.shoppy.services;

import com.ar.shoppy.domain.client;
import com.ar.shoppy.repository.clientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class clientService {

    @Autowired
    private clientRepository clientRepo;

    public void registerClient (client client){
        clientRepo.save(client);
    }

    public List<client> clientList(){
        return clientRepo.findAll();
    }

    public client clientListById(String id){
        Optional<client> response = clientRepo.findById(id);
        if (response.isPresent()){
            client client = response.get();
            return client;
        }else{
            return null;
        }
    }

    public client clientListByName(String name){
        Optional<client>response = clientRepo.findByClient(name);
        if (response.isEmpty()){
            client client = response.get();
            return client;
        }else{
            return null;
        }
    }

    public void deleteClient(String id){
        Optional<client> response = clientRepo.findById(id);
        if (response.isPresent()){
            clientRepo.delete(response.get());
        }
    }
}
