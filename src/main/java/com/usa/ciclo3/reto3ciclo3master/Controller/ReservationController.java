package com.usa.ciclo3.reto3ciclo3master.Controller;

import com.usa.ciclo3.reto3ciclo3master.entities.Admin;
import com.usa.ciclo3.reto3ciclo3master.entities.Category;
import com.usa.ciclo3.reto3ciclo3master.entities.Reservation;
import com.usa.ciclo3.reto3ciclo3master.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation p){
        return reservationService.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update (@RequestBody Reservation p){return reservationService.update(p);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return reservationService.delete(id);
    }
}
