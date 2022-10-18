package com.usa.ciclo3.reto3ciclo3master.Controller;

import com.usa.ciclo3.reto3ciclo3master.entities.Admin;
import com.usa.ciclo3.reto3ciclo3master.entities.Cabin;
import com.usa.ciclo3.reto3ciclo3master.service.CabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Cabin")
public class CabinController {

    @Autowired
    private CabinService cabinService;

    @GetMapping("/all")
    public List<Cabin> getAll(){
        return cabinService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin save(@RequestBody Cabin c){
        return cabinService.save(c);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin update (@RequestBody Cabin p){return cabinService.update(p);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return cabinService.delete(id);
    }
}
