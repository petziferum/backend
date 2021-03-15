package com.petziferum.backend.controller;

import com.petziferum.backend.model.Product;
import com.petziferum.backend.repository.ShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopRepo shoprepo;


    @PostMapping("/saveProduct")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        System.out.println("Empfange " +product.getProductName() +" "+product.getProductTitle() + " " + product.getProductClass());
        Product p = new Product(product.getProductName(), product.getProductTitle());
        p.setStock(product.getStock());
        p.setPrice(product.getPrice());
        p.setProductClass(product.getProductClass());
        p.setProductDescription(product.getProductDescription());

        shoprepo.save(p);

        System.out.println("Neues Produkt: " + p.getProductName());

        return ResponseEntity.ok(p);
    }

    @GetMapping("/categories")
    public ArrayList<String> getProductCategories(){
        ArrayList<String> categories = new ArrayList<>();
        ArrayList<Product> p = shoprepo.findAll();
        p.forEach(c -> {categories.add(c.getProductClass());});
        Set<String> set = new HashSet<>(categories);  //Set wird erstellt, da dadurch die duplikate entfernt werden.
        categories.clear();
        categories.addAll(set);
        return categories;
    }

    @GetMapping("/allProducts")
    public ArrayList<Product> listAllProducts(){

        ArrayList list = shoprepo.findAll();
        return list;
    }

}
