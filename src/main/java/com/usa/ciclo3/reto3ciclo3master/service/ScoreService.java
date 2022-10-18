package com.usa.ciclo3.reto3ciclo3master.service;

import com.usa.ciclo3.reto3ciclo3master.entities.Product;
import com.usa.ciclo3.reto3ciclo3master.entities.Score;
import com.usa.ciclo3.reto3ciclo3master.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }

    public Optional<Score> getProduct(int id){
        return scoreRepository.getScore(id);
    }

    public Score save(Score p){
        if(p.getId()==null){
            return scoreRepository.save(p);
        }else{
            Optional<Score> e = scoreRepository.getScore(p.getId());
            if (e.isPresent()){
                return p;
            }else{
                return scoreRepository.save(p);
            }
        }
    }

    public Score update(Score p){
        if (p.getId()!=null){
            Optional<Score> q= scoreRepository.getScore(p.getId());
            if (q.isPresent()){
                if(p.getMessage()!=null){
                    q.get().setMessage(p.getMessage());
                }
                if(p.getReservation()!=null){
                    q.get().setReservation(p.getReservation());
                }
                if(p.getScoreReservation()!=null){
                    q.get().setScoreReservation(p.getScoreReservation());
                }
                scoreRepository.save(q.get());
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
        Optional<Score> p = scoreRepository.getScore(id);
        if (p.isPresent()) {
            scoreRepository.delete(p.get());
            flag = true;
        }
        return flag;
    }
}
