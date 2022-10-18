package com.usa.ciclo3.reto3ciclo3master.service;

import com.usa.ciclo3.reto3ciclo3master.entities.Category;
import com.usa.ciclo3.reto3ciclo3master.entities.Client;
import com.usa.ciclo3.reto3ciclo3master.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return  clientRepository.getAll();
    }

    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save (Client c){
        if (c.getIdClient()==null){
            return clientRepository.save(c);
        }else{
            Optional<Client> e= clientRepository.getClient(c.getIdClient());
            if (e.isPresent()){
                return c;
            }else{
                return clientRepository.save(c);
            }
        }
    }

    public Client update(Client p){
        if (p.getIdClient()!=null){
            Optional<Client> q= clientRepository.getClient(p.getIdClient());
            if (q.isPresent()){
                if(p.getEmail()!=null){
                    q.get().setEmail(p.getEmail());
                }
                if(p.getPassword()!=null){
                    q.get().setPassword(p.getPassword());
                }
                if(p.getName()!=null){
                    q.get().setName(p.getName());
                }
                if(p.getAge()!=null){
                    q.get().setAge(p.getAge());
                }
                if(p.getMessages()!=null){
                    q.get().setMessages(p.getMessages());
                }
                if(p.getReservations()!=null){
                    q.get().setReservations(p.getReservations());
                }
                clientRepository.save(q.get());
                return q.get();
            }else{
                return p;
            }
        }else{
            return p;
        }
    }
    public boolean delete(int id) {
        boolean flag = false;
        Optional<Client> p = clientRepository.getClient(id);
        if (p.isPresent()) {
            clientRepository.delete(p.get());
            flag = true;
        }
        return flag;
    }
}
