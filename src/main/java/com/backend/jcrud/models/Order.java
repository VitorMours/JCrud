package com.backend.jcrud.models;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.backend.jcrud.enums.OrderStatus;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;


@Entity 
@Table(name="tb_orders")
public class Order implements Serializable{ 
    private static final long serialVersionUID = 1L;

    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column 
    private Instant moment;

    @Column 
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name="client_id")
    private User client;


    @OneToMany(mappedBy="order", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Payment> payments = new ArrayList<>();


    @ManyToMany 
    @JoinTable( name = "tb_order_products", 
                joinColumns=@JoinColumn(name="order_id"), 
                inverseJoinColumns=@JoinColumn(name="products_id"))
    private List<Product> products = new ArrayList<>();




    public Order(){}

    public Order(User client, OrderStatus orderStatus, Instant moment) {
        this.client = client;
        this.orderStatus = orderStatus;
        this.moment = moment;
    }    

    // Getters 
    public User getClient(){
        return this.client;
    }

    public Instant getMoment(){
        return this.moment;
    }

    public ArrayList<Payment> getPayments(){
        return (ArrayList<Payment>) this.payments;
    }

    public OrderStatus getOrderStatus(){
        return this.orderStatus;
    }

    // Setters 
    public void setClient(User newClient){
        this.client = newClient;
    }

    public void setPayments(ArrayList<Payment> newPayments){
        this.payments = newPayments;
    }

    public void setMoment(Instant newMoment){
        this.moment = newMoment;
    }

    public void setOrderStatus(OrderStatus status){
        this.orderStatus = status;
    }

    @PrePersist
    public void prePersist(){
        if(this.moment == null){
            this.moment = Instant.now();
        }
    }
}
