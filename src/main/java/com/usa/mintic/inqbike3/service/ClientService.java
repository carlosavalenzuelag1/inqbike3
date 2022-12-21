package com.usa.mintic.inqbike3.service;


import com.usa.mintic.inqbike3.entities.Client;
import com.usa.mintic.inqbike3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }

    public Client save(Client client) {
        if (client.getIdClient() == null) {
            return clientRepository.save(client);
        } else {
            Optional<Client> client1 = clientRepository.getClient(client.getIdClient());
            if (client1.isPresent()) {
                return client;
            } else {
                return clientRepository.save(client);

            }
        }
    }
    public Client update(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> qk = clientRepository.getClient(client.getIdClient());
            if (qk.isPresent()) {
                if (client.getName() != null) {
                    qk.get().setName(client.getName());
                }
                if (client.getEmail() != null) {
                    qk.get().setEmail(client.getEmail());
                }
                if (client.getPassword() != null) {
                    qk.get().setPassword(client.getPassword());
                }
                if (client.getAge() != null) {
                    qk.get().setAge(client.getAge());
                }

                clientRepository.save(qk.get());

                return qk.get();

            } else {
                return client;
            }

        } else {
            return client;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Client>p= clientRepository.getClient(id);
        if(p.isPresent()){
            clientRepository.delete(p.get());
            flag=true;

        }
        return flag;

    }

}
