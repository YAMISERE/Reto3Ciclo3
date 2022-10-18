package com.usa.ciclo3.reto3ciclo3master.Controller;

import com.usa.ciclo3.reto3ciclo3master.entities.Admin;
import com.usa.ciclo3.reto3ciclo3master.entities.Category;
import com.usa.ciclo3.reto3ciclo3master.entities.Score;
import com.usa.ciclo3.reto3ciclo3master.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/all")
    public List<Score> getAll(){
        return scoreService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score p){ return scoreService.save(p);}

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score update (@RequestBody Score p){return scoreService.update(p);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return scoreService.delete(id);
    }
}
