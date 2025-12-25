package com.backend.jcrud.models; 


import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table; 
import jakarta.persistence.Column;
import jakarta.persistence.Id; 
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity 
@Table(name="tb_posts")
public class Post implements Serializable {
  private static final long serialVersion UID = 1L;  

  @Id 
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  @Column
  private String title; 

  @Column
  private String content; 
  
  @Column
  private User owner; 
  
  @Column
  private boolean visibility;


  public Post(){}

  public Post(String title, String content, User owner, boolean visibility){
    this.title = title;
    this.content = content;
    this.owner = owner; 
    this.visibility = visibility;
  }


  // Setters 
  public String setTitle(String newTitle){
    this.title = newTitle;
  }

  public String setContent(string newContent){
    this.content = content;
  }

  public User setOwner(User newOwner){
    this.owner = newOwner;
  }

  public boolean setVisibility(boolean newVisibility){
    this.visibility = newVisibility;
  }


}
