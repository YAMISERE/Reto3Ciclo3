package com.usa.ciclo3.reto3ciclo3master.service;

import com.usa.ciclo3.reto3ciclo3master.entities.Admin;
import com.usa.ciclo3.reto3ciclo3master.entities.Product;
import com.usa.ciclo3.reto3ciclo3master.repository.AdminRepository;
import com.usa.ciclo3.reto3ciclo3master.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll(){
        return adminRepository.getAll();
    }

    public Optional<Admin> getProduct(int id){
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin p){
        if(p.getId()==null){
            return adminRepository.save(p);
        }else{
            Optional<Admin> e = adminRepository.getAdmin(p.getId());
            if (e.isPresent()){
                return p;
            }else{
                return adminRepository.save(p);
            }
        }
    }

    public Admin update(Admin p){
        if (p.getId()!=null){
            Optional<Admin> q= adminRepository.getAdmin(p.getId());
            if (q.isPresent()){
                if(p.getName()!=null){
                    q.get().setName(p.getName());
                }
                if(p.getEmail()!=null){
                    q.get().setEmail(p.getEmail());
                }
                if(p.getPassword()!=null){
                    q.get().setPassword(p.getPassword());
                }
                adminRepository.save(q.get());
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
        Optional<Admin> p = adminRepository.getAdmin(id);
        if (p.isPresent()) {
            adminRepository.delete(p.get());
            flag = true;
        }
        return flag;
    }
}
