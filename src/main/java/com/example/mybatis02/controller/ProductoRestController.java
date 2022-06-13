/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mybatis02.controller;

import com.example.mybatis02.model.Producto;
import com.example.mybatis02.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Micaela
 */
@RestController
@RequestMapping("/producto")
public class ProductoRestController {
 @Autowired
    private ProductoService productoService;
 
 
   @GetMapping("/all")
    public List< Producto> getActors(){
        return productoService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity< Producto> getActor(@PathVariable int id){
        Producto producto = productoService.findById(id);
        return ResponseEntity.ok(producto);
    }
    
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable int id) {        
        productoService.deleteById(id);
    }
    @PostMapping("/add")
    public int addPost(@RequestBody  Producto producto) {  
        return productoService.insert(producto);
    }
    @PutMapping("/edit")
    public int editPost(@RequestBody  Producto producto) {  
        Producto act = new  Producto(producto.getIdproducto(),producto.getIdproveedor(),producto.getDescripcion(),producto.getPreciocosto(),producto.getPreciocosto());
        return productoService.update(producto); 
    }
}
