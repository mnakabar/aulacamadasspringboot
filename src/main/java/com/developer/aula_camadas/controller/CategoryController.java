package com.developer.aula_camadas.controller;


import com.developer.aula_camadas.entities.Category;
import com.developer.aula_camadas.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public ResponseEntity<List<Category>> findall(){
        List<Category> list = categoryRepository.findAll();
        return ResponseEntity.ok().body(list);
    }

   @GetMapping(value = "/{id}")
   public ResponseEntity<Category> findById(@PathVariable Long id){
        Category category = categoryRepository.findById(id).get();

        return ResponseEntity.ok().body(category);
    }

}
