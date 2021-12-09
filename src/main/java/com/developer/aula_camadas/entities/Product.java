package com.developer.aula_camadas.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Product implements Serializable {

    private static final  long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product(Long id, String name, Double price,Category category){
        this.id = id;
        this.name = name;
        this.price = price;
        this.category= category;

    }

    public Product() {

    }



    public Long getId(){
        return id;
    }
    public String getName(){
        return name;

    }
    public Double getPrice(){
        return price;
    }
    public void setId(Long id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(Double price){
        this.price = price;
    }


}
