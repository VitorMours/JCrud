package com.jcrud.api.entities;

import java.io.Serializable;

public class User implements Serializable{


    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    public User() {}

    public User(Long id, String name, String email, String phone, String password){
        super();
        this.id = id;
        this.name = name; 
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    // Setters
    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password){
        this.password = password;
    }

    //Getters
    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPhone(){
        return this.phone;
    }
    public String getPassword(){
        return this.password;
    }
    public Long getId(){
        return this.id;
    }
}