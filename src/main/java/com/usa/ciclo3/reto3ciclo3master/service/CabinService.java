package com.usa.ciclo3.reto3ciclo3master.service;

import com.usa.ciclo3.reto3ciclo3master.entities.Cabin;
import com.usa.ciclo3.reto3ciclo3master.repository.CabinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CabinService {

    @Autowired
    private CabinRepository cabinRepository;

    public List<Cabin> getAll(){
        return cabinRepository.getAll();
    }

    public Optional<Cabin> getCabin(int id){
        return cabinRepository.getCabin(id);
    }

    public Cabin save(Cabin c){
        if(c.getId()==null){
            return cabinRepository.save(c);
        }else{
            Optional<Cabin> e = cabinRepository.getCabin(c.getId());
            if(e.isPresent()){
                return c;
            }else {
                return cabinRepository.save(c);
            }
        }
    }

    public Cabin update(Cabin c){
        if (c.getId()!=null){
            Optional<Cabin> q = cabinRepository.getCabin(c.getId());
            if(q.isPresent()){
                if(c.getName()!=null){
                    q.get().setName(c.getName());
                }
                if(c.getBrand()!=null){
                    q.get().setBrand(c.getBrand());
                }
                if(c.getRooms()!=null){
                    q.get().setRooms(c.getRooms());
                }
                if(c.getDescription()!=null){
                    q.get().setDescription(c.getDescription());
                }
                if(c.getCategory()!=null){
                    q.get().setCategory(c.getCategory());
                }
                if(c.getMessages()!=null){
                    q.get().setMessages(c.getMessages());
                }
                if(c.getMessages()!=null){
                    q.get().setMessages(c.getMessages());
                }
                if(c.getReservations()!=null){
                    q.get().setReservations(c.getReservations());
                }
                cabinRepository.save(q.get());
                return q.get();
            }else{
                return c;
            }
        }else{
            return c;
        }
    }

    public boolean delete(int id){
        boolean flag = false;
        Optional<Cabin> c = cabinRepository.getCabin(id);
        if (c.isPresent()){
            cabinRepository.delete(c.get());
            flag = true;
        }
        return flag;
    }
}
