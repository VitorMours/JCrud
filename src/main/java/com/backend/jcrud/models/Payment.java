package com.backend.jcrud.models;

import java.time.Instant;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity 
@Table(name="tb_payments")
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    public Instant moment;

    @Column(nullable=false)
    private Boolean paid = false;

    public Payment(){}

    public Payment(Instant moment, Boolean paid){
        this.moment = moment;
        this.paid = paid;
    }

    // Getters and Setters
    public Long getId(){
        return this.id;
    }

    public Instant getMoment(){
        return this.moment;
    }

    public Boolean getPaid(){
        return this.paid;
    }

    public void setMoment(Instant newMoment){
        this.moment = newMoment;
    }

    public void setPaid(Boolean isPaid){
        this.paid = isPaid;
    }
}
