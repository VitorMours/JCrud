package com.backend.jcrud.models;

import java.io.Serializable;
import java.time.Instant;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity 
@Table(name="tb_orders")
public class Order implements Serializable{ 
    private static final long serialVersionUID = 1L;

    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column 
    private Instant moment;

    @ManyToOne
    @JoinColumn(name="client_id")
    private User client;

    public Order(){}

    public Order(User client) {
        this.client = client;
    }    

    // Getters 
    public User getClient(){
        return this.client;
    }

    public Instant getMoment(){
        return this.moment;
    }

    // Setters 
    public void setClient(User newClient){
        this.client = newClient;
    }

    public void setMoment(Instant newMoment){
        this.moment = newMoment;
    }
}
