package com.backend.jcrud.models;

import java.time.Instant;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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


    @ManyToOne 
    @JoinColumn(name="order_id")
    private Order order;

    public Payment(){}

    public Payment(Instant moment, Boolean paid, Order order){
        this.moment = moment;
        this.paid = paid;
        this.order = order;
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

    public Order getOrder(){
        return this.order;
    }

    public void setMoment(Instant newMoment){
        this.moment = newMoment;
    }

    public void setPaid(Boolean isPaid){
        this.paid = isPaid;
    }

    public void setOrder(Order newOrder){
        this.order = newOrder;
    }
}
