package com.ar.shoppy.services;

import com.ar.shoppy.models.Cliente;
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
    public void registerClient (Cliente client){
        clientRepo.save(client);
    }

    public List<Cliente> clientListAll(){
        return clientRepo.findAll();
    }

    public Cliente clientListById(String id){
        Optional<Cliente> response = clientRepo.findById(id);
        return response.orElse(null);
    }

    public Cliente clientListByName(String name){
        Optional<Cliente>response = clientRepo.findByClientName(name);
        return response.orElse(null);
    }

    @Transactional
    public void deleteClient(String id){
        Optional<Cliente> response = clientRepo.findById(id);
        response.ifPresent(client -> clientRepo.delete(client));
    }
}
