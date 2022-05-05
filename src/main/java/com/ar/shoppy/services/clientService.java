package com.ar.shoppy.services;

import com.ar.shoppy.models.Client;
import com.ar.shoppy.repositories.clientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class clientService {

    @Autowired
    private clientRepository clientRepo;

    @Transactional
    public void registerClient (Client client){
        clientRepo.save(client);
    }

    public List<Client> clientListAll(){
        return clientRepo.findAll();
    }

    public Client clientListById(String id){
        Optional<Client> response = clientRepo.findById(id);
        return response.orElse(null);
    }

    public Client clientListByName(String name){
        Optional<Client>response = clientRepo.findByClient(name);
        return response.orElse(null);
    }

    @Transactional
    public void deleteClient(String id){
        Optional<Client> response = clientRepo.findById(id);
        response.ifPresent(client -> clientRepo.delete(client));
    }
}
