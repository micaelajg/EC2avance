/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mybatis02.controller;

import com.example.mybatis02.model.Cliente;
import com.example.mybatis02.model.Proveedor;
import com.example.mybatis02.service.ProveedorService;
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
@RequestMapping("/proveedor")
public class ProveedorRestController {
    @Autowired
    private ProveedorService proveedorService;
    
    @GetMapping("/all")
    public List<Proveedor> getActors(){
        return proveedorService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> getActor(@PathVariable int id){
        Proveedor proveedor = proveedorService.findById(id);
        return ResponseEntity.ok(proveedor);
    }
    
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable int id) {        
        proveedorService.deleteById(id);
    }
    @PostMapping("/add")
    public int addPost(@RequestBody Proveedor proveedor) {  
        return proveedorService.insert(proveedor);
    }
    @PutMapping("/edit")
    public int editPost(@RequestBody Proveedor proveedor) {  
        Proveedor act = new Proveedor(proveedor.getIdproveedor(),proveedor.getNombre(),proveedor.getTelefono(), proveedor.getDireccion());
        return proveedorService.update(proveedor); 
    }
}
