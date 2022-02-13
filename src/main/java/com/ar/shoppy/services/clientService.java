package com.ar.shoppy.services;


import com.ar.shoppy.domain.Client;
import com.ar.shoppy.repository.clientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class clientService {

    @Autowired
    private clientRepository clientRepo;

    public void registerClient (Client client){
        clientRepo.save(client);
    }

    public List<Client> clientList(){
        return clientRepo.findAll();
    }

    public Client clientListId(String id){
        Optional<Client> response = clientRepo.findById(id);
        if (response.isPresent()){
            Client client = response.get();
            return client;
        }else{
            return null;
        }
    }

    public Client clientListName(String name){
        Optional<Client>response = clientRepo.findByClient(name);
        if (response.isEmpty()){
            Client client = response.get();
            return client;
        }else{
            return null;
        }
    }

    public void deleteClient(String id){
        Optional<Client> response = clientRepo.findById(id);
        if (response.isPresent()){
            clientRepo.delete(response.get());
        }
    }
}
