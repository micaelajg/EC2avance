/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mybatis02.controller;

import com.example.mybatis02.model.Cliente;
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
import com.example.mybatis02.service.ClienteService;

/**
 *
 * @author Micaela
 */
@RestController
@RequestMapping("/cliente")
public class ClienteRestController {
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/all")
    public List<Cliente> getActors(){
        return clienteService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getActor(@PathVariable int id){
        Cliente cliente = clienteService.findById(id);
        return ResponseEntity.ok(cliente);
    }
    
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable int id) {        
        clienteService.deleteById(id);
    }
    @PostMapping("/add")
    public int addPost(@RequestBody Cliente cliente) {  
        return clienteService.insert(cliente);
    }
    @PutMapping("/edit")
    public int editPost(@RequestBody Cliente cliente) {  
        Cliente act = new Cliente(cliente.getIdcliente(),cliente.getNombre(),cliente.getTelefono(), cliente.getDireccion());
        return clienteService.update(cliente);
    }
}