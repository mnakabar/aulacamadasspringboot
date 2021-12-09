package com.developer.aula_camadas.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Category implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

   @JsonIgnore
   @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();

    public Category(Long id, String name){
        this.id = id;
        this.name = name;
    }
    public Category(){

    }
    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public void setId(Long id){
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
