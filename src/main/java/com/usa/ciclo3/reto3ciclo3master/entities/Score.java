package com.usa.ciclo3.reto3ciclo3master.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="score")
public class Score implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer scoreReservation;
    private String message;

    @OneToOne
    @JsonIgnoreProperties ("score")
    private Reservation reservation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScoreReservation() {
        return scoreReservation;
    }

    public void setScoreReservation(Integer scoreReservation) {
        this.scoreReservation = scoreReservation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
