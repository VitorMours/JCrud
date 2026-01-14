package com.backend.jcrud.models;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;


@Entity 
@Table(name="tb_products")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name; 

    @Column 
    private String description; 

    @Column(nullable=false)
    private Double price;

    @ManyToMany
    @JoinTable(name = "tb_order_products", 
                joinColumns=@JoinColumn(name="products_id"), 
                inverseJoinColumns=@JoinColumn(name="order_id"))
    private List<Order> orders = new ArrayList<>();


    //@Column(nullable=false)
    //private Url

    public Product(){}

    public Product(String name, String description, Double price){
        this.name = name; 
        this.description = description;
        this.price = price;
    }


    // Getters & Setters


    public Long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public Double getPrice(){
        return this.price;
    }

    public void setName(String newName){
        this.name = newName;
    }
    
    public void setDescription(String newDescription){
        this.description = newDescription;
    }
    
    public void setPrice(Double newPrice){
        this.price = newPrice;
    }

}
